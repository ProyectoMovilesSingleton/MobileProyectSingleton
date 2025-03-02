package com.example.demo.filters;

import com.example.demo.entities.Movil;

public class MovilMinRAMFilter extends MovilFilter<Integer> {

	
	
	public MovilMinRAMFilter(Integer paramaterT) {
		super(paramaterT);
	}

	@Override
	public boolean filter(Movil movil) {
		return movil.getRam()>=paramaterT;
	}

}
