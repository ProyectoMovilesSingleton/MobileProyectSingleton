package com.example.demo.filtersDecorator;

import com.example.demo.entities.Movil;

public class NoMovilFilter implements Filter<Movil> {

	@Override
	public boolean filter(Movil t) {
		return true;
	}

}
