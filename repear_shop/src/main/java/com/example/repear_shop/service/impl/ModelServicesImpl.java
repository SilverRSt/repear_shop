package com.example.repear_shop.service.impl;

import com.example.repear_shop.data.entity.Model;
import com.example.repear_shop.data.repository.ModelRepository;
import com.example.repear_shop.service.ModelService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ModelServicesImpl implements ModelService {
    private final ModelRepository repository;

    public ModelServicesImpl(ModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Model> getModels() {
        return this.repository.findAll();
    }

    @Override
    public Model createModel(Model model) {
        return this.repository.save(model);
    }

    @Override
    public Model updateModel(String modelName, Model model) {
        model.setModel(modelName);
        return this.repository.save(model);
    }

    @Override
    public void deleteModel(String modelName) {
        this.repository.deleteById(modelName);
    }
}
