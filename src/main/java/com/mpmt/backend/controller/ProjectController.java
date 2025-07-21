package com.mpmt.backend.controller;

import com.mpmt.backend.entity.Project;
import com.mpmt.backend.entity.ProjectMember;
import com.mpmt.backend.service.ProjectService;
import com.mpmt.backend.service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectMemberService projectMemberService) {
        this.projectService = projectService;
        this.projectMemberService = projectMemberService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().<Project>build());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<Project> getProjectByName(@PathVariable String name) {
        return projectService.getProjectByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        if (projectService.getProjectById(id).isPresent()) {
            projectService.deleteProject(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}/members")
    public ResponseEntity<List<ProjectMember>> getMembersForProject(@PathVariable Long id) {
        List<ProjectMember> members = projectMemberService.findMembersByProjectId(id);
        return ResponseEntity.ok(members);
    }
}
