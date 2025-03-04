package com.example.demo.filtersDecorator;

import com.example.demo.entities.Movil;

public abstract class MovilFilter<T> implements Filter<Movil> {
	protected static MovilFilter<Boolean> instance;
	protected T t;
	protected boolean valid = true;
	protected Filter<Movil> filter;

	protected MovilFilter(T t, Filter<Movil> filter ) {
		super();
		this.t = t;
		this.filter = filter;
	}
	
	public static MovilFilter<Boolean> getInstance() {
		return instance;
	}

	public static void setInstance(MovilFilter<Boolean> instance) {
		MovilFilter.instance = instance;
	}

	@Override
	public boolean filter(Movil t) {
		return valid;
	}
	
	
	
	
	
}
