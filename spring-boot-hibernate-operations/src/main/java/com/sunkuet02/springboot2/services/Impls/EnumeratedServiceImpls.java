package com.sunkuet02.springboot2.services.Impls;

import com.sunkuet02.springboot2.dao.EnumeratedRepository;
import com.sunkuet02.springboot2.models.EnumeratedEntity;
import com.sunkuet02.springboot2.services.EnumeratedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnumeratedServiceImpls implements EnumeratedService {

    @Autowired
    private EnumeratedRepository versioningRepository;

    @Override
    public EnumeratedEntity getEnumeratedEntity(Long id) {
        return versioningRepository.getOne(id);
    }

    @Override
    public EnumeratedEntity createEntity(EnumeratedEntity entity) {
        EnumeratedEntity ve = entity;
        if(entity.getId() != null && entity.getId() > 0) {
            ve = versioningRepository.getOne(entity.getId());
            ve.setName(entity.getName());
        }
        return  versioningRepository.save(ve);
    }
}
