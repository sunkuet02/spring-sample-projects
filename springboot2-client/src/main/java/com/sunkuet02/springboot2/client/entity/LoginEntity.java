/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunkuet02.springboot2.client.entity;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maverick
 */

@Data
public class LoginEntity {
    private String USER_NAME;
    private String PASSWORD;
    private Integer id;
    private String token;
    private String csrfToken;
    private String locationLevel;
    private String locationId;
    private String lang;
    private String userDesignation;
    private HashMap<String,String> menumap;
    private Map<String,String> userRole;
    
    
//    private SecurityHandlerResolver systemSecurityHandlerResolver;
    private Integer recordPerPage;
    private Integer sso;
    private String userType;
    private Long loginTimeMilis;
    private Long samlTokenExpireAfterMilis;
    private String tokenType;
    private String sessionUuid;
    private Integer sessionTimeOut;

}