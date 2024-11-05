package com.ertedemo.shared.services.impl;

import com.ertedemo.domain.model.entites.Tenant;
import com.ertedemo.domain.persistence.TenantRepository;
import com.ertedemo.domain.services.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public List<Tenant> getAll() {
        return tenantRepository.findAll();
    }

    @Override
    public Optional<Tenant> getById(Long tenantId) {
        return tenantRepository.findById(tenantId);
    }

    @Override
    public Tenant create(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant update(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public ResponseEntity<?> delete(Long tenantId) {
        tenantRepository.deleteById(tenantId);
        return null;
    }

    @Override
    public Long login(String email, String password) {
        Optional<Tenant> tenant = tenantRepository.findByEmail(email);
        if (tenant.isPresent() && tenant.get().getPassword().equals(password)) {
            return tenant.get().getId();
        }
        return null;
    }
}