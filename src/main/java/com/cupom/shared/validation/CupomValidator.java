package com.cupom.shared.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CupomValidator implements ConstraintValidator<ValidCupom, String> {
    private static final String CUPOM_REGEX = "^[0-9]{6}$";

    @Override
    public void initialize(ValidCupom constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cupom, ConstraintValidatorContext context) {
        if (cupom == null || !cupom.matches(CUPOM_REGEX)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Cupom inválido: deve conter exatamente 6 dígitos numéricos.")
                    .addConstraintViolation();
            return false; // Retorne false ao invés de lançar uma exceção.
        }
        return true;
    }
}
