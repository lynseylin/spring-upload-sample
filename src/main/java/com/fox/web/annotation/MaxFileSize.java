package com.fox.web.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by linxiaofang on 2017/9/28.
 */
@Documented
@Constraint(validatedBy = MaxFileSizeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxFileSize {
    String message() default "{MaxFileSize}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}