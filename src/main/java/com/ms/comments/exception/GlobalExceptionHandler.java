package com.ms.comments.exception;

import com.ms.comments.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerResourceNotFoundException(ResourceNotFoundException exception,
                                                                   WebRequest request){

        ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                     WebRequest request){

        Map<String, String> mapErrors = new HashMap<>();
        List<String> reasons = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String clave = ((FieldError)error).getField();
            String value = error.getDefaultMessage();
            mapErrors.put(clave, value);
            reasons.add(String.format("El campo %s %s", ((FieldError)error).getField(), error.getDefaultMessage()));
        });

        ErrorDTO errorDTO = new ErrorDTO("Bad Request",request.getDescription(false), reasons);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handlerException(Exception exception,
                                                                         WebRequest request){

        ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
