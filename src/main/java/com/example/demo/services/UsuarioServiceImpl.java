package com.example.demo.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.CreateUserDTO;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.RoleEnum;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.security.jwt.JwtUtils;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder;
    
    // Constructor para la inyección de dependencias
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RoleRepository roleRepository, JwtUtils jwtUtils,
                               BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(CreateUserDTO createUserDTO) {
        // Convertir el String[] de roles a Set<String>
        Set<String> rolesSet = new HashSet<>(Arrays.asList(createUserDTO.roles()));
        
        // Verificar si los roles proporcionados son válidos usando RoleEnum
        if (!RoleEnum.validate(rolesSet)) {
            throw new IllegalArgumentException("Uno o más roles proporcionados son inválidos.");
        }

        // Encriptar la contraseña
        String encryptedPassword = passwordEncoder.encode(createUserDTO.password());

        // Crear el usuario
        Usuario usuario = new Usuario();
        usuario.setUsername(createUserDTO.username());
        usuario.setPassword(encryptedPassword);
        usuario.setEmail(createUserDTO.username() + "@example.com"); // Asignar un email por defecto

        // Asignar roles al usuario
        Set<RoleEntity> roles = new HashSet<>();
        for (String roleName : createUserDTO.roles()) {
            // Buscar cada rol en la base de datos
            RoleEntity role = roleRepository.findByName(RoleEnum.valueOf(roleName))
                    .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado: " + roleName));
            roles.add(role);
        }
        usuario.setRoles(roles);

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
        return true;
    }

    @Override
    public boolean delete(String username) {
        // Buscar al usuario por su nombre de usuario
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + username));
        
        // Eliminar el usuario de la base de datos
        usuarioRepository.delete(usuario);
        return true;
    }

    @Override
    public void refreshingToken(HttpServletResponse response, String authorizationHeader) throws Exception {
        // Implementación de la lógica para refrescar el token (si usas refresh tokens)
        String refreshToken = authorizationHeader.substring(7); // "Bearer " + token
        if (jwtUtils.validateToken(refreshToken)) {
            String username = jwtUtils.getUsernameFromToken(refreshToken);
            // Generar un nuevo access token
            String newAccessToken = jwtUtils.generateAccessToken(username);
            response.setHeader("Access-Token", newAccessToken);
        } else {
            throw new Exception("El refresh token es inválido o ha expirado");
        }
    }

    @Override
    public Usuario getUserByUsername(String username) {
        // Buscar al usuario por su nombre de usuario
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + username));
    }
}
