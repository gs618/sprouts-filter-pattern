package com.github.gs618.sprouts.pattern.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sgao
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface FilterPriority {

	/**
	 * more smaller, more soon it will be invoked
	 * @return priority
	 */
	int value() default Filter.DEFAULT_PRIORITY;
}
