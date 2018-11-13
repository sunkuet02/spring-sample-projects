package com.sunkuet02.springbootvalidation.dto;

import com.sunkuet02.springbootvalidation.validations.ValidAccount;
import lombok.Data;

import java.io.Serializable;

@Data
@ValidAccount
public class Account implements Serializable {

    private Double balance;
}
