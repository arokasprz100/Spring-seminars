package com.zti.example1a.project;

import java.util.List;

public interface ProjectService {
	
	List<Project> findAll();
	
	void save(Project project);
}
