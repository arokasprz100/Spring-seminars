package com.zti.example4.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zti.example4.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
}

