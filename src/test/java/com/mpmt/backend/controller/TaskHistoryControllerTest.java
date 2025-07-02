package com.mpmt.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpmt.backend.entity.TaskHistory;
import com.mpmt.backend.service.TaskHistoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskHistoryController.class)
class TaskHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskHistoryService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /api/task-histories should create a history")
    void shouldCreateTaskHistory() throws Exception {
        TaskHistory history = new TaskHistory();
        history.setTaskId(1L);
        history.setChangedBy(2L);
        history.setChangeDate(new Date());
        history.setChangeDescription("History created");

        when(service.createHistory(any(TaskHistory.class))).thenReturn(history);

        mockMvc.perform(post("/api/task-histories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(history)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.changeDescription").value("History created"));
    }

    @Test
    @DisplayName("GET /api/task-histories/{id} should return a history")
    void shouldGetTaskHistoryById() throws Exception {
        TaskHistory history = new TaskHistory();
        history.setId(1L);
        history.setTaskId(1L);
        history.setChangedBy(2L);
        history.setChangeDescription("Task updated");

        when(service.getHistoryById(1L)).thenReturn(Optional.of(history));

        mockMvc.perform(get("/api/task-histories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.changeDescription").value("Task updated"));
    }
}
