package com.cupom.shared.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CupomValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCupom {
    String message() default "O cupom informado é inválido ou não existe.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
