package com.sunkuet02.springbootvalidation.validations;

import com.sunkuet02.springbootvalidation.validations.validators.ValidUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidUserValidator.class })
@Documented
public @interface ValidUser {

    String message() default "Is not valid user request";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}