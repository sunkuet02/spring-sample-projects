package com.sunkuet02.springboot2.controllers;

import com.sunkuet02.springboot2.models.VersioningEntity;
import com.sunkuet02.springboot2.services.VersioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/versioning")
public class VersioningController {

    private VersioningService versioningService;

    @Autowired
    public VersioningController(VersioningService service) {
        this.versioningService = service;
    }

    @GetMapping("/{id}")
    public VersioningEntity getVersioningEntity(@PathVariable("id") Long id) {
        return versioningService.getVersioningEntity(id);
    }

    @PostMapping
    public VersioningEntity createVersioningEntity(@RequestBody VersioningEntity entity) {
        return versioningService.createEntity(entity);
    }

}
