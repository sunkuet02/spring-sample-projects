package com.sunkuet02.springboot2.controllers;

import com.sunkuet02.springboot2.models.EnumeratedEntity;
import com.sunkuet02.springboot2.services.EnumeratedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enumerated")
public class EnumeratedController {

    private EnumeratedService versioningService;

    @Autowired
    public EnumeratedController(EnumeratedService service) {
        this.versioningService = service;
    }

    @GetMapping("/{id}")
    public EnumeratedEntity getEnumeratedEntity(@PathVariable("id") Long id) {
        return versioningService.getEnumeratedEntity(id);
    }

    @PostMapping
    public EnumeratedEntity createEnumeratedEntity(@RequestBody EnumeratedEntity entity) {
        return versioningService.createEntity(entity);
    }

}
