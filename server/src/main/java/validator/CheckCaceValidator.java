package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by kylong on 2016/5/16.
 */
public class CheckCaceValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;

    private String flag;


    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return  true;
        boolean isValid = false;
        if (caseMode == CaseMode.UPPER)
            isValid =  value.equals(value.toUpperCase());
        if (caseMode == CaseMode.LOWER)
            isValid = value.equals(value.toLowerCase());
        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("大小写错误").addConstraintViolation();
        }
        return  isValid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
