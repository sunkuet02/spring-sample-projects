package com.sunkuet02.springboot2.dao;

import com.sunkuet02.springboot2.models.VersioningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersioningRepository extends JpaRepository<VersioningEntity, Long> {
}
