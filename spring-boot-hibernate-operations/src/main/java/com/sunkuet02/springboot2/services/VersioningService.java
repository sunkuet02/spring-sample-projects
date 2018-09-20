package com.sunkuet02.springboot2.services;

import com.sunkuet02.springboot2.models.VersioningEntity;

public interface VersioningService {
    VersioningEntity getVersioningEntity(Long id);

    VersioningEntity createEntity(VersioningEntity entity);
}
