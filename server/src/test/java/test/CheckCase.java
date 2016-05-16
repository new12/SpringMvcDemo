package test;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
/**
 * Created by kylong on 2016/5/16.
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface CheckCase {
    String message() default "hi";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    CaseMode caseMode();
}
