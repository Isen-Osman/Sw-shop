package mk.finki.ukim.mk.swshop.dto;

import java.util.Date;

public record JwtExceptionResponse(
        Date timestamp,
        int status,
        String error,
        String message,
        String path
) {

    public JwtExceptionResponse(int status, String error, String message, String path) {
        this(new Date(), status, error, message, path);
    }

}

