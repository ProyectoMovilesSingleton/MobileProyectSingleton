package com.example.demo.filters;

import com.example.demo.entities.Movil;

public class MovilPantallaFilter extends MovilFilter<String>{

	public MovilPantallaFilter(String paramaterT) {
		super(paramaterT);
	}

	@Override
	public boolean filter(Movil movil) {
		return movil.getPantalla().getTecnologia().equals(paramaterT);
	}

}
