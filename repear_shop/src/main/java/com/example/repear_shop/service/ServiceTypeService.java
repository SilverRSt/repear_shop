package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.ServiceType;
import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> getServiceTypes();

    ServiceType createService(ServiceType serviceType);

    ServiceType updateService(Long id, ServiceType serviceType);

    void deleteService(Long id);
}
