package com.cupom.shared;

import com.cupom.application.dtos.errosResponseDTO.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ErrorResponseMapper {
    public static ErrorResponse mapToErrorResponse(ResponseStatusException ex){
        return new ErrorResponse(
        ex.getStatus().value(),
        ex.getStatus().getReasonPhrase(),
        ex.getMessage()

        );
    }

    public static ErrorResponse mapToErrorResponse(Exception ex){
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage()

        );
    }
}
