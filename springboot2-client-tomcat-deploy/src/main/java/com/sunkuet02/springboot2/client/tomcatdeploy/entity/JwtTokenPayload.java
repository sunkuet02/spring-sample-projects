package com.sunkuet02.springboot2.client.tomcatdeploy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtTokenPayload {

    private String sub;

    private List<String> roles;

    private Date iat;

    private Date exp;
}
