package com.springboot.project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project4.model.Logins;

public interface LoginRepository extends JpaRepository<Logins,String>{
	Logins findByEmailAndPassword(String email, String password);
}
