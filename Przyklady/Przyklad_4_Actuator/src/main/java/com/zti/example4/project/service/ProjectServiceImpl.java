package com.zti.example4.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zti.example4.project.model.Project;
import com.zti.example4.project.repository.ProjectRepository;
import com.zti.example4.project.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}
	
	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}
}
