package com.zti.example1b.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zti.example1b.project.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
}
