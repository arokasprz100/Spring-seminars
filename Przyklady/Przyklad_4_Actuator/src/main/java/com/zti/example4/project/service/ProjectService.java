package com.zti.example4.project.service;

import java.util.List;

import com.zti.example4.project.model.Project;

public interface ProjectService {
	
	List<Project> findAll();
	
	void save(Project project);
}
