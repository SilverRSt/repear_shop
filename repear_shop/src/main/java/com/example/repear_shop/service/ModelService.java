package com.example.repear_shop.service;

import com.example.repear_shop.data.entity.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModels();
    Model createModel(Model model);
    Model updateModel(String modelName, Model model);
    void deleteModel(String modelName);
}
