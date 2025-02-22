package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Dimension;

public interface DimensionRepository extends JpaRepository<Dimension, Integer> {

}
