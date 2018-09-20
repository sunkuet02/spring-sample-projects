package com.sunkuet02.springboot2.services;

import com.sunkuet02.springboot2.models.EnumeratedEntity;

public interface EnumeratedService {
    EnumeratedEntity getEnumeratedEntity(Long id);

    EnumeratedEntity createEntity(EnumeratedEntity entity);
}
