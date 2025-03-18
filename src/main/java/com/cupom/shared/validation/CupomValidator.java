package com.cupom.shared.validation;

import com.cupom.infrastructure.exception.CupomException;
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
            Exception ConstraintViolationException = null;
            throw new CupomException("ddfdsfds", new RuntimeException());
        }
        return true;
    }
}
