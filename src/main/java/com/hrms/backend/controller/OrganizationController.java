package com.hrms.backend.controller;

import com.hrms.backend.dto.OrganizationDTO;
import com.hrms.backend.entity.Organization;
import com.hrms.backend.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

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
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<Organization> organizations = organizationService.getAllOrganizations();
        
        List<OrganizationDTO> safeData = organizations.stream()
                .map(org -> new OrganizationDTO(
                        org.getId(),
                        org.getName(),
                        org.getAddress(),
                        org.getContactEmail()
                ))
                .toList();

        return ResponseEntity.ok(safeData);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(@PathVariable Long id, @RequestBody Organization orgDetails) {
        Organization updatedOrg = organizationService.updateOrganization(id, orgDetails);
        
        OrganizationDTO safeData = new OrganizationDTO(
                updatedOrg.getId(),
                updatedOrg.getName(),
                updatedOrg.getAddress(),
                updatedOrg.getContactEmail()
        );
        return ResponseEntity.ok(safeData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.ok("Organization deleted successfully.");
    }
}