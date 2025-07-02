package com.mpmt.backend.service;

import com.mpmt.backend.entity.TaskAssignment;
import com.mpmt.backend.repository.TaskAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskAssignmentService {

    private final TaskAssignmentRepository repository;

    @Autowired
    public TaskAssignmentService(TaskAssignmentRepository repository) {
        this.repository = repository;
    }

    public List<TaskAssignment> getAll() {
        return repository.findAll();
    }

    public Optional<TaskAssignment> getById(Long id) {
        return repository.findById(id);
    }

    public List<TaskAssignment> getByTaskId(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    public List<TaskAssignment> getByProjectMemberId(Long projectMemberId) {
        return repository.findByProjectMemberId(projectMemberId);
    }

    public TaskAssignment getByTaskIdAndProjectMemberId(Long taskId, Long projectMemberId) {
        return repository.findByTaskIdAndProjectMemberId(taskId, projectMemberId);
    }

    public TaskAssignment create(TaskAssignment assignment) {
        return repository.save(assignment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
