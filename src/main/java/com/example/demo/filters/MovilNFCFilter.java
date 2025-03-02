package com.example.demo.filters;

import com.example.demo.entities.Movil;

public class MovilNFCFilter extends MovilFilter<Boolean> {
	
	public MovilNFCFilter(Boolean paramaterT) {
		super(paramaterT);
	}

	@Override
	public boolean filter(Movil movil) {
		return movil.isNFC()==paramaterT;
	}

}
