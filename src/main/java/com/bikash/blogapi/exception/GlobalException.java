package com.bikash.blogapi.exception;

import com.bikash.blogapi.apiresponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExHandler(ResourceNotFoundException ex) {

        String message = ex.getMessage();

        ApiResponse apiResponse =new ApiResponse(message ,false);
        return new ResponseEntity<>(apiResponse , HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String ,String>>  methodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String ,String> response=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            response.put(field ,defaultMessage);
        });
        return new ResponseEntity<>(response ,HttpStatus.BAD_REQUEST);
    }
}
