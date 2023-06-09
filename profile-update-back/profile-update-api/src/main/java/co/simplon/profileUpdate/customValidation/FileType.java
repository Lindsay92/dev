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
@Constraint(validatedBy = FileTypeValidator.class)
public @interface FileType {

    // Permet de préciser un message d'erreur quand on gère les messages coté back
    String message() default "File type is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}