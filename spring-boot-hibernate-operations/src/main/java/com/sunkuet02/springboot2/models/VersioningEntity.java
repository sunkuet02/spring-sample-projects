package com.sunkuet02.springboot2.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "versioning_entity")
public class VersioningEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Version
    private Long version;
}
