package com.mpmt.backend.service;


import com.mpmt.backend.entity.ProjectMember;
import com.mpmt.backend.entity.Project;
import com.mpmt.backend.entity.User;
import com.mpmt.backend.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import com.mpmt.backend.entity.RoleType;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;

    @Autowired
    public ProjectMemberService(ProjectMemberRepository projectMemberRepository) {
        this.projectMemberRepository = projectMemberRepository;
    }

    public List<ProjectMember> getAllMembers() {
        return projectMemberRepository.findAll();
    }

    public Optional<ProjectMember> getById(Long id) {
        return projectMemberRepository.findById(id);
    }

    public ProjectMember createProjectMember(ProjectMember member) {
        return projectMemberRepository.save(member);
    }

    public List<ProjectMember> getByProject(Project project) {
        return projectMemberRepository.findByProject(project);
    }

    public List<ProjectMember> getByUser(User user) {
        return projectMemberRepository.findByUser(user);
    }

    public Optional<ProjectMember> getByUserAndProject(User user, Project project) {
        return projectMemberRepository.findByUserAndProject(user, project);
    }

    public void deleteProjectMember(Long id) {
        projectMemberRepository.deleteById(id);
    }

    public List<Project> findProjectsByUserId(Long userId) {
        List<ProjectMember> memberships = projectMemberRepository.findByUserId(userId);
        return memberships.stream()
                .map(ProjectMember::getProject)
                .collect(Collectors.toList());
    }

    public List<ProjectMember> getMembersByProjectId(Long projectId) {
        return projectMemberRepository.findByProjectId(projectId);
    }

    public List<ProjectMember> findByProjectId(Long projectId) {
        return projectMemberRepository.findByProjectId(projectId);
    }

    public List<ProjectMember> findMembersByProjectId(Long projectId) {
        return projectMemberRepository.findByProjectId(projectId);
    }

    public Optional<ProjectMember> updateRole(Long projectMemberId, String newRole) {
        Optional<ProjectMember> pmOpt = projectMemberRepository.findById(projectMemberId);
        if (pmOpt.isPresent()) {
            ProjectMember pm = pmOpt.get();
            pm.setRole(RoleType.valueOf(newRole)); // Attention : valide si la string correspond bien à une valeur d'enum
            projectMemberRepository.save(pm);
            return Optional.of(pm);
        } else {
            return Optional.empty();
        }
    }




}
