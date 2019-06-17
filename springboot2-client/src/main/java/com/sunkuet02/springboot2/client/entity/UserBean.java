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
public class UserBean {
    private String loginName;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String nidId;
    private String designation;
    private String dateOfBirth;
    private String email;
    private String phone;
    private String mobile;
    private String status;
    private String passNeverExp;
    
    /*
    public User getUserServiceObject(UserBean userBean,boolean operationTypeCreate){
        User user = new User();
        user.setFirstName(userBean.getFirstName());
        user.setLastName(userBean.getLastName());
        user.setNid(userBean.getNidId());
        user.setDesignation(userBean.getDesignation());
        user.setDateOfBirth(Utils.getXMLGregorianCalendarObject(userBean.getDateOfBirth()));
        user.setEmail(userBean.getEmail());
        user.setPhone(userBean.getPhone());
        user.setMobile(userBean.getMobile());
        if(operationTypeCreate){
            user.setLoginName(userBean.getLoginName());
            user.setStatus(userBean.getStatus());
            user.setType(Defs.USER_TYPE_EXTERNAL);
            user.setLoginPassword(userBean.getPassword());
            if(userBean.getPassNeverExp()!= null || !userBean.getPassNeverExp().isEmpty()){
                user.setPasswordExpires(true);
            }else{
                user.setPasswordExpires(false);
            }
        }
        return user;
    }*/
}
