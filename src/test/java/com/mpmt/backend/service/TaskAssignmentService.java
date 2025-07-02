package com.mpmt.backend.service;

import com.mpmt.backend.entity.TaskAssignment;
import com.mpmt.backend.repository.TaskAssignmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class TaskAssignmentServiceTest {

    private TaskAssignmentRepository repository;
    private TaskAssignmentService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(TaskAssignmentRepository.class);
        service = new TaskAssignmentService(repository);
    }

    @Test
    void shouldReturnAssignmentById() {
        TaskAssignment assignment = new TaskAssignment();
        assignment.setId(99L);
        given(repository.findById(99L)).willReturn(Optional.of(assignment));

        Optional<TaskAssignment> found = service.getById(99L);
        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(99L);
    }
}
