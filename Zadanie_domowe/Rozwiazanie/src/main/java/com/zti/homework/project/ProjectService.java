package com.zti.homework.project;

import java.util.List;

public interface ProjectService {
	
	List<Project> findAll();
	
	void save(Project project);
	
	void deleteById(Long id);
}
