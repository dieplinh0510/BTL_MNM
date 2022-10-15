package com.hit.base_1.application.annotation;

import com.hit.base_1.application.annotation.validator.StringFormatDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = StringFormatDateValidator.class)
public @interface StringFormatDate {

    String message() default "err.invalid.date_format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
