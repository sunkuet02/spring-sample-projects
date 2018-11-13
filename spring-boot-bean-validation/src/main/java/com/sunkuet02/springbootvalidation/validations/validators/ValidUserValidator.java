package com.sunkuet02.springbootvalidation.validations.validators;

import com.sunkuet02.springbootvalidation.dto.User;
import com.sunkuet02.springbootvalidation.validations.ValidUser;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidUserValidator implements ConstraintValidator<ValidUser, User> {
    @Override
    public void initialize(ValidUser validUser) {
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if(user.getEmail() == null || "".equals(user.getEmail())) {
            return false;
        }

        if(!user.getEmail().endsWith("@sunkuet02.com")) {
            throw new IllegalArgumentException("Email address should end with sunkuet02.com");
        }

        return true;
    }
}
