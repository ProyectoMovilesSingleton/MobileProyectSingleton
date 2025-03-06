package com.example.demo.filters;

import com.example.demo.entities.Movil;

public class MovilMinPrecioFilter extends MovilFilter<Double> {

	public MovilMinPrecioFilter(Double paramaterT) {
		super(paramaterT);
	}

	@Override
	public boolean filter(Movil movil) {
		return movil.getPrecio()>=paramaterT;
	}

}
