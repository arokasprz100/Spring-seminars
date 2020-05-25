package com.zti.homework.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	@RequestMapping("/{id}/delete")
	public String deleteProject(@PathVariable String id, Model model) {
		projectService.deleteById(Long.parseLong(id));
		model.addAttribute("id", id);
		return "delete-project-confirm";
	}
}
