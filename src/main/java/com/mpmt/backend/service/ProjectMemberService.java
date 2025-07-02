package com.mpmt.backend.service;

import com.mpmt.backend.entity.ProjectMember;
import com.mpmt.backend.entity.Project;
import com.mpmt.backend.entity.User;
import com.mpmt.backend.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
