package com.test.cicddoodle.doodle.controller;

import com.test.cicddoodle.doodle.entity.Doodle;
import com.test.cicddoodle.doodle.service.DoodleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DoddleController {

    private final DoodleService doodleService;

    @PostMapping("/api/v1/doodles")
    public ResponseEntity<?> saveDoodle(@RequestBody Doodle doodle) {
        try {
            log.info("Received request to save doodle: {}", doodle.getName());
            Doodle savedDoodle = doodleService.saveDoodle(doodle);
            return ResponseEntity.ok(savedDoodle);
        } catch (Exception ex) {
            log.error("Error saving doodle", ex);
            return ResponseEntity.status(500).body("Error saving doodle: " + ex.getMessage());
        }
    }

    @PutMapping("/api/v1/doodles")
    public ResponseEntity<?> updateDoodle(@RequestBody Doodle doodle) {
        try {
            log.info("Received request to update doodle: {}", doodle.getId());
            Doodle updatedDoodle = doodleService.updateDoodle(doodle);
            return ResponseEntity.ok(updatedDoodle);
        } catch (Exception ex) {
            log.error("Error updating doodle", ex);
            return ResponseEntity.status(500).body("Error updating doodle: " + ex.getMessage());
        }
    }

    @GetMapping("/api/v1/doodles/{id}")
    public ResponseEntity<?> getDoodleById(@PathVariable Long id) {
        try {
            log.info("Received request to get doodle by id: {}", id);
            Doodle doodle = doodleService.getDoodleById(id);
            return ResponseEntity.ok(doodle);
        } catch (Exception ex) {
            log.error("Error fetching doodle by id", ex);
            return ResponseEntity.status(404).body("Doodle not found: " + ex.getMessage());
        }
    }

    @DeleteMapping("/api/v1/doodles/{id}")
    public ResponseEntity<?> deleteDoodle(@PathVariable Long id) {
        try {
            log.warn("Received request to delete doodle by id: {}", id);
            doodleService.deleteDoodle(id);
            return ResponseEntity.ok("Doodle with id => " + id + " deleted successfully");
        } catch (Exception ex) {
            log.error("Error deleting doodle", ex);
            return ResponseEntity.status(500).body("Error deleting doodle: " + ex.getMessage());
        }
    }

    @GetMapping("/api/v1/doodles")
    public ResponseEntity<?> getAllDoodles() {
        try {
            log.info("Received request to get all doodles");
            return ResponseEntity.ok(doodleService.getAllDoodles());
        } catch (Exception ex) {
            log.error("Error fetching all doodles", ex);
            return ResponseEntity.status(500).body("Error fetching doodles: " + ex.getMessage());
        }
    }
}
