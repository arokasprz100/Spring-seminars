package com.zti.example1b.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zti.example1b.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
}
