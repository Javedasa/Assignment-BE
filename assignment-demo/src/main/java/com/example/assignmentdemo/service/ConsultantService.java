package com.example.assignmentdemo.service;

import com.example.assignmentdemo.entity.Consultant;
import com.example.assignmentdemo.entity.ConsultantRequest;
import com.example.assignmentdemo.exception.RequestNotFoundException;
import com.example.assignmentdemo.repository.ConsultantRepository;
import com.example.assignmentdemo.repository.ConsultantRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultantService {

    @Autowired
    private ConsultantRequestRepository requestRepository;

    @Autowired
    private ConsultantRepository consultantRepository;

    public List<ConsultantRequest> getAllConsultantRequests() {
        return requestRepository.findAll();
    }

    public ConsultantRequest approveConsultantRequest(Long requestId) throws Exception{
        // Step 1: Retrieve the consultant request from the database
        Optional<ConsultantRequest> optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent()) {
            ConsultantRequest request = optionalRequest.get();

            // Step 2: Update the status of the request to approved or accepted
            request.setStatus("APPROVED");

            // Step 3 (Optional): Create a new Consultant entity using the details from the ConsultantRequest entity
            Consultant newConsultant = new Consultant();
            newConsultant.setName(request.getName());
            newConsultant.setAge(request.getAge());
            newConsultant.setPhoneNo(request.getPhoneNo());


            // Step 4: Save the updated ConsultantRequest entity back to the database
            ConsultantRequest updatedRequest = requestRepository.save(request);

            // Step 5 (Optional): Save the new Consultant entity to the database
            // consultantRepository.save(newConsultant);

            // Step 6: Return the updated ConsultantRequest entity
            return updatedRequest;
        } else {
            throw new RequestNotFoundException("Request with ID " + requestId + " not found");
        }

    }

    public ConsultantRequest rejectConsultantRequest(Long requestId) throws RequestNotFoundException {
        // Step 1: Retrieve the consultant request from the database
        Optional<ConsultantRequest> optionalRequest = requestRepository.findById(requestId);

        if (optionalRequest.isPresent()) {
            ConsultantRequest request = optionalRequest.get();

            // Step 2: Update the status of the request to rejected
            request.setStatus("REJECTED");

            // Step 3: Save the updated ConsultantRequest entity back to the database
            ConsultantRequest updatedRequest = requestRepository.save(request);

            // Step 4: Return the updated ConsultantRequest entity
            return updatedRequest;
        } else {
            // Handle the case where the request with the given ID is not found
            throw new RequestNotFoundException("Request with ID " + requestId + " not found");
        }
    }

    public Consultant addConsultantDetails(Consultant consultant) {
        return consultantRepository.save(consultant);
    }

    public List<Consultant> getAllConsultants() {
        return consultantRepository.findAll();
    }

    public Consultant getConsultantById(Long consultantId) {
        return consultantRepository.findById(consultantId).orElse(null);
    }

    // Other methods for getting consultants by name, job role, etc.
}


