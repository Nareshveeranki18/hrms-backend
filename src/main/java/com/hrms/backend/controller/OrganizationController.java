package com.hrms.backend.controller;

import com.hrms.backend.entity.Organization;
import com.hrms.backend.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations") // Matches your other endpoints
public class OrganizationController {

    // Injecting the Service, NOT the Repository
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        Organization savedOrg = organizationService.saveOrganization(organization);
        return ResponseEntity.ok(savedOrg);
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }
}