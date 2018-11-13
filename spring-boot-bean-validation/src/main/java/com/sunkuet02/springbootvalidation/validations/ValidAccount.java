package com.sunkuet02.springbootvalidation.validations;

import com.sunkuet02.springbootvalidation.validations.validators.ValidAccountValidator;
import com.sunkuet02.springbootvalidation.validations.validators.ValidUserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidAccountValidator.class })
@Documented
public @interface ValidAccount {

    String message() default "Invalid request";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
