package com.example.demo.filtersDecorator;

public interface Filter<T> {
	public boolean filter(T t);
}
