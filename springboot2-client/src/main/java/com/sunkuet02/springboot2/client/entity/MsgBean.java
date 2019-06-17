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
public class MsgBean {

    private String errorMessage;
    private String successMessage;
    private String status;

    public MsgBean(String stat) {
        this.status = stat;
        this.errorMessage = "";
        this.successMessage = "";
    }

}
