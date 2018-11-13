package com.sunkuet02.springbootvalidation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Metadata {
    String code;

    String message;

    String description;
}