/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunkuet02.springboot2.client.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ataur Rahman
 */

@Data
@NoArgsConstructor
public class NIDVerificationBean extends MsgBean{
    
    private String data;
    private String photo;
    private String serviceId;
    private String serviceDate;
    private String messageText;
    private String verificationText;
    
}
