package com.hrms.backend.service;

import com.hrms.backend.entity.Organization;
import java.util.List;

public interface OrganizationService {
    Organization saveOrganization(Organization organization);
    List<Organization> getAllOrganizations();
}