package com.ms.user.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class HandleException {

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity lanzarExcepcion(MyHandleException exception){

        return new ResponseEntity("Excepcion personalizada  " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity excepcionSistema(Exception e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Excepcion del sistema  " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validException(MethodArgumentNotValidException e){

        List<String> listErros = new ArrayList<>();
        for (FieldError error: e.getBindingResult().getFieldErrors()) {
            listErros.add(error.getField() +": "  + error.getDefaultMessage());
        }

        return  ResponseEntity.badRequest().body(listErros);
    }




}
