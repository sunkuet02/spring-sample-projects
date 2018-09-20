package com.sunkuet02.springboot2.utils.enums.converters;

import com.sunkuet02.springboot2.utils.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenderConverters implements AttributeConverter<Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        if(gender == null) {
            return  null;
        }

        return gender.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Integer value) {
        return Gender.get(value);
    }
}
