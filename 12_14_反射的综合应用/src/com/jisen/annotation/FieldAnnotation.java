package com.jisen.annotation;

import java.lang.annotation.*;
import com.jisen.myenum.*;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
	String fieldName();
	FieldType fieldtype();
}
