package com.sunkuet02.springboot2.client.tomcatdeploy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest implements Serializable{

    private String username;

    private String password;
}
