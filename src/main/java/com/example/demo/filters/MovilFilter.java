package com.example.demo.filters;

import com.example.demo.entities.Movil;

public abstract class MovilFilter<T> implements Filter<Movil> {
		protected T paramaterT;

		public MovilFilter(T paramaterT) {
			super();
			this.paramaterT = paramaterT;
		}
		
		public abstract boolean filter(Movil movil);
	
}
