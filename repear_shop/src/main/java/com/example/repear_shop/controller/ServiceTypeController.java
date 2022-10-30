package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.ServiceType;
import com.example.repear_shop.service.ServiceTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceTypeController {
    private final ServiceTypeService service;

    public ServiceTypeController(ServiceTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceType> getServiceTypes(){
        return this.service.getServiceTypes();
    }

    @PostMapping
    public ServiceType createService(@RequestBody ServiceType serviceType){
        return this.service.createService(serviceType);
    }

    @PutMapping("/{id}")
    public ServiceType updateService(@PathVariable Long id, @RequestBody ServiceType serviceType){
        return this.service.updateService(id, serviceType);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id){
        this.service.deleteService(id);
    }

}
