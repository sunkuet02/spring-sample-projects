package com.sunkuet02.springboot2.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Ataur Rahman on 09-May-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable{

    private String access_token;

    private String username;
}
