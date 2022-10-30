package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.Model;
import com.example.repear_shop.service.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService services;

    public ModelController(ModelService services) {
        this.services = services;
    }

    @GetMapping
    public List<Model> getModels() {
        return this.services.getModels();
    }

    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return this.services.createModel(model);
    }

    @PutMapping("/{modelName}")
    public Model updateModel(@PathVariable String modelName, @RequestBody Model model) {
        return this.services.updateModel(modelName, model);
    }

    @DeleteMapping("/{modelName}")
    public void deleteModel(@PathVariable String modelName) {
        this.services.deleteModel(modelName);
    }
}
