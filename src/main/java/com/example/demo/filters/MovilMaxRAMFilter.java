package com.example.demo.filters;

import com.example.demo.entities.Movil;

public class MovilMaxRAMFilter extends MovilFilter<Integer>{

	public MovilMaxRAMFilter(Integer paramaterT) {
		super(paramaterT);
	}

	@Override
	public boolean filter(Movil movil) {
		return movil.getRam()<=paramaterT;
	}

}
