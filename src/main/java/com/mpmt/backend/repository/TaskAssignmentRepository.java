package com.mpmt.backend.repository;

import com.mpmt.backend.entity.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {
    // Trouver toutes les assignments pour une tâche
    List<TaskAssignment> findByTaskId(Long taskId);

    // Trouver toutes les assignments pour un membre d’un projet
    List<TaskAssignment> findByProjectMemberId(Long projectMemberId);

    // Trouver une assignment pour une tâche ET un membre de projet (unique normalement)
    TaskAssignment findByTaskIdAndProjectMemberId(Long taskId, Long projectMemberId);
}
