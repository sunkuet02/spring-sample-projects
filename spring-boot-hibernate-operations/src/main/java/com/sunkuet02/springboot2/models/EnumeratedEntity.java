package com.sunkuet02.springboot2.models;

import com.sunkuet02.springboot2.utils.enums.Gender;
import com.sunkuet02.springboot2.utils.enums.converters.GenderConverters;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "enumerated_entity")
public class EnumeratedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated             // This will save ordinal values to database. Suppose, for 'MALE' 0 and 'FEMALE' 1
    public Gender gender;

    @Convert(converter = GenderConverters.class)
    public Gender genderValue;
}
