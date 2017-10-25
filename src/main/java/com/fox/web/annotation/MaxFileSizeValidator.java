package com.fox.web.annotation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: linxiaofang
 * @date: 2017/9/28
 */
public class MaxFileSizeValidator implements ConstraintValidator<MaxFileSize, MultipartFile> {
    @Override
    public void initialize(MaxFileSize param) {
    }
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext ctx) {
        return file != null && file.getSize() <= 5424880;
    }
}