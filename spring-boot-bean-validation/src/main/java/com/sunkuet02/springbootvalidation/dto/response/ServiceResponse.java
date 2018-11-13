package com.sunkuet02.springbootvalidation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceResponse<T> {
    Metadata meta;

    T data;
}