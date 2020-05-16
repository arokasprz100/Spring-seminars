package com.zti.example1b.project.service;

import java.util.List;

import com.zti.example1b.project.model.Project;

public interface ProjectService {
	
	List<Project> findAll();
	
	void save(Project project);
}
