package com.zti.example1b.project;

import java.util.List;


public interface ProjectService {
	
	List<Project> findAll();
	
	void save(Project project);
}
