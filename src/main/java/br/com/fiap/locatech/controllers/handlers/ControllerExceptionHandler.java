package br.com.fiap.locatech.controllers.handlers;

import br.com.fiap.locatech.dtos.ResourceNotFoundDTO;
import br.com.fiap.locatech.dtos.ValidationErrorDTO;
import br.com.fiap.locatech.service.exceptions.ResouceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResourceNotFoundDTO> handlerResourceNotFoundException (ResouceNotFoundException e ) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status.value()).body(new ResourceNotFoundDTO(e.getMessage(), status.value()));
    }
    @ExceptionHandler
    public ResponseEntity<ValidationErrorDTO> handlerMethodArgumentNotValidException (MethodArgumentNotValidException e ) {
        var status = HttpStatus.BAD_REQUEST;
        List<String> errors = new ArrayList<>();
        for (var error: e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        return ResponseEntity.status(status.value()).body(new ValidationErrorDTO(errors, status.value()));
    }

}
