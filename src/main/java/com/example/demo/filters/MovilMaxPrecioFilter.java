package com.example.demo.filters;

import com.example.demo.entities.Movil;

public class MovilMaxPrecioFilter extends MovilFilter<Double>{

	public MovilMaxPrecioFilter(Double paramaterT) {
		super(paramaterT);
	}

	@Override
	public boolean filter(Movil movil) {
		return movil.getPrecio()<=paramaterT;
	}

}
