package com.jisen.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableNameAnnotation {
	String tableName();
}
