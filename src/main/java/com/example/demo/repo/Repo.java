package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Model;


@Repository
public interface Repo extends JpaRepository <Model,Long> {

	

	Model findByUsername(String username);



}
