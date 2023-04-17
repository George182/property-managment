package com.mycompany.propertymanagement.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;
    }



}
