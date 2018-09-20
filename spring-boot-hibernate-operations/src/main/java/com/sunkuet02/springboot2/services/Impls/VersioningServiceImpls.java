package com.sunkuet02.springboot2.services.Impls;

import com.sunkuet02.springboot2.dao.VersioningRepository;
import com.sunkuet02.springboot2.models.VersioningEntity;
import com.sunkuet02.springboot2.services.VersioningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersioningServiceImpls implements VersioningService {

    @Autowired
    private VersioningRepository versioningRepository;

    @Override
    public VersioningEntity getVersioningEntity(Long id) {
        return versioningRepository.getOne(id);
    }

    @Override
    public VersioningEntity createEntity(VersioningEntity entity) {
        VersioningEntity ve = entity;
        if(entity.getId() != null && entity.getId() > 0) {
            ve = versioningRepository.getOne(entity.getId());
            ve.setValue(entity.getValue());
        }
        return  versioningRepository.save(ve);
    }
}
