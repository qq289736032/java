package com.jisen.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
	String value();
}
