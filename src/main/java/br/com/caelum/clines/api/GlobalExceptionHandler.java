package br.com.caelum.clines.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorPayload handle(MethodArgumentNotValidException exception) {
        var bindingResult = exception.getBindingResult();

        var response = new ErrorPayload();

        bindingResult.getGlobalErrors().forEach(objectError -> response.addError(objectError.getDefaultMessage()));

        bindingResult.getFieldErrors().forEach(fieldError -> response.addErrorForField(fieldError.getField(), fieldError.getDefaultMessage()));

        return response;
    }
}
