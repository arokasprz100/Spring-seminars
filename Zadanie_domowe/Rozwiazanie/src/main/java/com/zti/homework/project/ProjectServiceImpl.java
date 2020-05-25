package com.zti.homework.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public void deleteById(Long id) {
		projectRepository.deleteById(id);
	}
}