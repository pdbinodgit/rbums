package com.rbums.rbums.customException;


import com.rbums.rbums.customresponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(
                error->{
                    errors.put(error.getField(),error.getDefaultMessage());
                }
        );
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.BAD_REQUEST,"Validation error.",errors),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RbumsCustomException.class)

    public ResponseEntity<ApiResponse<?>> rbumsCustomException(RbumsCustomException e, WebRequest webRequest){

    return ResponseEntity.status(e.getStatus()).body(new ApiResponse<>(e.getStatus(), e.getMessage()));
    }
}
