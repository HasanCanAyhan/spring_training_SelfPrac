package com.cydeo.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // i can put the annotation top of the methods
@Retention(RetentionPolicy.RUNTIME) // it will work in the runtime
public @interface LoggingAnnotation {


}
