package com.mpmt.backend.controller;

import com.mpmt.backend.entity.TaskHistory;
import com.mpmt.backend.service.TaskHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-histories")
@CrossOrigin(origins = "*")
public class TaskHistoryController {

    private final TaskHistoryService service;

    @Autowired
    public TaskHistoryController(TaskHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskHistory> getAllHistories() {
        return service.getAllHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskHistory> getHistoryById(@PathVariable Long id) {
        return service.getHistoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-task/{taskId}")
    public List<TaskHistory> getHistoriesByTaskId(@PathVariable Long taskId) {
        return service.getHistoriesByTaskId(taskId);
    }

    @PostMapping
    public ResponseEntity<TaskHistory> createHistory(@RequestBody TaskHistory taskHistory) {
        return ResponseEntity.ok(service.createHistory(taskHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long id) {
        service.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}
