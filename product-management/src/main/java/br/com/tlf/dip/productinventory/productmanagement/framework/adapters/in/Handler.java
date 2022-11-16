package br.com.tlf.dip.productinventory.productmanagement.framework.adapters.in;

import br.com.tlf.dip.productinventory.productmanagement.domain.dto.MensagemErro;
import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = FeignException.class)
    protected ResponseEntity<MensagemErro> handlerClientJaCadastrado(FeignException exception) {
        return ResponseEntity.status(HttpStatus.valueOf(exception.status()))
                .body(new MensagemErro(String.valueOf(exception.status()), exception.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError ->
                        fieldError.getField() + "The field " +
                                ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemErro(validationList));
    }
}
