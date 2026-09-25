package com.hrms.backend.service;

import com.hrms.backend.entity.Organization;
import com.hrms.backend.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }
}