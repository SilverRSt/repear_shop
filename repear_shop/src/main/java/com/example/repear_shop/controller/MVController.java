package com.example.repear_shop.controller;

import com.example.repear_shop.data.entity.MV;
import com.example.repear_shop.service.MVService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvs")
public class MVController {
    private final MVService service;

    public MVController(MVService service) {
        this.service = service;
    }

    @GetMapping
    public List<MV> getMvs() {
        return this.service.getMvs();
    }

    @PostMapping
    public MV createMV(@RequestBody MV mv) {
        return this.service.createMV(mv);
    }

    @PutMapping("/{vin}")
    public MV updateMV(@PathVariable String vin,@RequestBody MV mv) {
        return this.service.updateMV(vin, mv);
    }

    @DeleteMapping("/{vin}")
    public void deleteMV(@PathVariable String vin) {
        this.service.deleteMV(vin);
    }
}
