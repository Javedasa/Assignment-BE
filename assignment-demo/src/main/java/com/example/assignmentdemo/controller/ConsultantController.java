package com.example.assignmentdemo.controller;

import com.example.assignmentdemo.entity.Consultant;
import com.example.assignmentdemo.entity.ConsultantRequest;
import com.example.assignmentdemo.exception.RequestNotFoundException;
import com.example.assignmentdemo.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @GetMapping("/consultant-requests")
    public List<ConsultantRequest> getAllConsultantRequests() {
        return consultantService.getAllConsultantRequests();
    }

    @PostMapping("/consultant-requests/{requestId}/approve")
    public ResponseEntity<Object> approveConsultantRequest(@PathVariable Long requestId) {
        try {
            ConsultantRequest approvedRequest = consultantService.approveConsultantRequest(requestId);
            return ResponseEntity.ok(approvedRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error approving consultant request: " + e.getMessage());
        }
    }

    @PostMapping("/consultant-requests/{requestId}/reject")
    public ResponseEntity<Object> rejectConsultantRequest(@PathVariable Long requestId) {
        try {
            ConsultantRequest rejectedRequest = consultantService.rejectConsultantRequest(requestId);
            return ResponseEntity.ok(rejectedRequest);
        } catch (RequestNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/consultants")
    public Consultant addConsultantDetails(@RequestBody Consultant consultant) {
        return consultantService.addConsultantDetails(consultant);
    }

    @GetMapping("/consultants")
    public List<Consultant> getAllConsultants() {
        return consultantService.getAllConsultants();
    }

    @GetMapping("/consultants/{consultantId}")
    public Consultant getConsultantById(@PathVariable Long consultantId) {
        return consultantService.getConsultantById(consultantId);
    }

    // Other endpoints for getting consultants by name, job role, etc.
}
