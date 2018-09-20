package com.sunkuet02.springboot2.dao;

import com.sunkuet02.springboot2.models.EnumeratedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnumeratedRepository extends JpaRepository<EnumeratedEntity, Long> {
}
