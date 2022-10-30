package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.ServiceType;
import com.example.repear_shop.data.repository.ServiceTypeRepository;
import com.example.repear_shop.service.ServiceTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    private final ServiceTypeRepository repository;

    public ServiceTypeServiceImpl(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ServiceType> getServiceTypes() {
        return this.repository.findAll();
    }

    @Override
    public ServiceType createService(ServiceType serviceType) {
        return this.repository.save(serviceType);
    }

    @Override
    public ServiceType updateService(Long id, ServiceType serviceType) {
        serviceType.setServiceId(id);
        return this.repository.save(serviceType);
    }

    @Override
    public void deleteService(Long id) {
        this.repository.deleteById(id);
    }
}
