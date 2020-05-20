package com.zti.example1a.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	@RequestMapping("/")
	public String getProjects(Model model) {
		List<Project> projects = projectService.findAll();
		model.addAttribute("projects", projects);
		return "list-projects";
	}
	
	@GetMapping
	@RequestMapping("/addProjectForm")
	public String showAddProjectForm(Project project) {
		return "add-project";
	}
	
	@PostMapping
	@RequestMapping("/add")
	public String addProject(Project project, BindingResult result, Model model) {
		projectService.save(project);
		return "add-project-confirm";
	}
}
