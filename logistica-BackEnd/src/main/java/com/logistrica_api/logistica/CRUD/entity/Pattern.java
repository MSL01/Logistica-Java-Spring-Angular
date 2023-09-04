package com.logistrica_api.logistica.CRUD.entity;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pattern {

    String regexp();

    String message() default "El valor no cumple con el formato especificado.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}