package com.example.demo.security.jwt;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
	// / EncryptedKeyGenerator en web 256 en hex
	// https://asecuritysite.com/encryption/plain
	@Value("${jwt.secret.key}")
	private String secretKey;

	@Value("${jwt.time.expiration}")
	private String timeExpiration;

	public String generateAccessToken(String username) {
		String compact = Jwts.builder()
				// la parte publica
				.issuedAt(Date.valueOf(LocalDate.now().plus(1, ChronoUnit.DAYS)))
				.subject(username)
				// caducando
				.expiration(Date.from(LocalDateTime.now().plusSeconds(30).atZone(ZoneId.systemDefault()).toInstant()))
				// la parte secreta
				.signWith(getSignatureKey())
				.compact();
		log.debug("JwtUtils: creandotoken " + compact);
		return compact;

	}

	public String generateRefreshToken(Usuario user) {
		return Jwts.builder()
				.subject(user.getUsername())
				.issuedAt(Date.valueOf(LocalDate.now()))
				.signWith(getSignatureKey())
				.compact();
	}

	public Boolean isTokenValid(String token) {
		try {
			getAllClaims(token);
			return true;
		} catch (Exception e) {
			log.error("JWTUtils:token invalido " + e.getMessage());
			return false;
		}
	}

	public String getUSerNameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	public SecretKey getSignatureKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

	private Claims getAllClaims(String token) {
		return Jwts.parser().verifyWith(getSignatureKey()).build().parseSignedClaims(token).getPayload();
	}

	private <T> T getClaim(String token, Function<Claims, T> claimsFunctin) {
		Claims allClaims = getAllClaims(token);
		return claimsFunctin.apply(allClaims);
	}
	
	public String getUsernameFromToken(String token) {
        Claims claims = ((JwtParser) Jwts.parser()  // Usar el parser directo
            .setSigningKey(secretKey)  // Usa la clave secreta para verificar la firma
)
            .parseClaimsJws(token)  // Analiza el JWT
            .getBody();  // Obtiene los 'Claims' del JWT
        return claims.getSubject();  // El 'subject' es el nombre de usuario
    }

    public boolean validateToken(String token) {
        try {
            ((JwtParser) Jwts.parser()  // Usar el parser directo
                .setSigningKey(secretKey)  // Usa la clave secreta para verificar la firma
)
                .parseClaimsJws(token);  // Intenta analizar el JWT
            return true;  // Si no lanza una excepción, el token es válido
        } catch (Exception e) {
            return false;  // Si hay una excepción, el token no es válido
        }
    }
}
