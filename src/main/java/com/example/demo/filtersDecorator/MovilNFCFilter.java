package com.example.demo.filtersDecorator;

import com.example.demo.entities.Movil;

public class MovilNFCFilter extends MovilFilter<Boolean> implements Filter<Movil>{

	public MovilNFCFilter(Boolean t, Filter<Movil> filter) {
		super(t, filter);
	}

	@Override
	public boolean filter(Movil t) {
		return super.filter(t);
	}
	
	

}
