package com.sunkuet02.springboot2.client.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Ataur Rahman on 09-May-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest implements Serializable{

    private String username;

    private String password;
}
