package com.zti.example1b.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zti.example1b.project.model.Project;
import com.zti.example1b.project.repository.ProjectRepository;

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
