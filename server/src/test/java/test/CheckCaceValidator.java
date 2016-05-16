package test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by kylong on 2016/5/16.
 */
public class CheckCaceValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;


    @Override
    public void initialize(CheckCase constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
