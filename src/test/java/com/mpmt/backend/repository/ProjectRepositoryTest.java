package com.mpmt.backend.repository;

import com.mpmt.backend.entity.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    @DisplayName("Devrait sauvegarder et retrouver un projet par nom")
    void shouldSaveAndFindProjectByName() {
        Project project = new Project();
        project.setName("Projet TDD");
        project.setDescription("Un projet créé en TDD");
        projectRepository.save(project);

        Optional<Project> found = projectRepository.findByName("Projet TDD");
        assertThat(found).isPresent();
        assertThat(found.get().getDescription()).isEqualTo("Un projet créé en TDD");
    }
}
