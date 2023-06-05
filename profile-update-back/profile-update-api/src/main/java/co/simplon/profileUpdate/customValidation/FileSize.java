package co.simplon.profileUpdate.customValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = FileSizeValidator.class)
public @interface FileSize {

    String message() default "File Size is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    // TODO Auto-generated constructor stub
}
