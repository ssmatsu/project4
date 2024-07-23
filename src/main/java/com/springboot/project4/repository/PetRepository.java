package com.springboot.project4.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project4.model.Pets;

public interface PetRepository extends JpaRepository<Pets,Integer>{
	Pets findById(int id);
	ArrayList<Pets> findAll();
	
}
