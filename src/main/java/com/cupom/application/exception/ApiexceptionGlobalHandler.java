package com.cupom.application.exception;

import com.cupom.application.dtos.errosResponseDTO.ErrorResponse;
import com.cupom.infrastructure.exception.CupomException;
import com.cupom.infrastructure.exception.EntityNotFound;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiexceptionGlobalHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    @Autowired
    public ApiexceptionGlobalHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("Erro de Validação");
        problemDetail.setDetail("Erro ao validar os campos da requisição.");
        problemDetail.setType(URI.create("https://localhost:8081/erros/campos-invalidos"));
        problemDetail.setProperty("errors", errors);

        return handleExceptionInternal(ex, problemDetail, headers, status, request);
    }
    @ExceptionHandler(EntityNotFound.class)
    public ProblemDetail cupomExceptionHandle(CupomException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle(e.getMessage());
        problemDetail.setType(URI.create("https://localhost:8081/erros/erros-regra-de-negocio"));
        problemDetail.setDetail("faliu aqui natan");
        return problemDetail;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegry(DataIntegrityViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Recurso ja esta em uso");
        problemDetail.setType(URI.create("https://localhost:8081/erros/recurso-em-uso"));

        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CupomException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(CupomException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

}
