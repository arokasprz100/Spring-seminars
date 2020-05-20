package com.zti.example4.project;

import java.util.List;

public interface ProjectService {
	
	List<Project> findAll();
	
	void save(Project project);
}
