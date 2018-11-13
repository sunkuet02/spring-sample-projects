package com.sunkuet02.springbootvalidation.validations.validators;

import com.sunkuet02.springbootvalidation.dto.Account;
import com.sunkuet02.springbootvalidation.validations.ValidAccount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidAccountValidator implements ConstraintValidator<ValidAccount, Account> {
    @Override
    public void initialize(ValidAccount validAccount) {
    }

    @Override
    public boolean isValid(Account account, ConstraintValidatorContext constraintValidatorContext) {
        if(account.getBalance() < 0.0) {
            throw new IllegalArgumentException("Account must not less than 0.");
        }

        return true;
    }
}
