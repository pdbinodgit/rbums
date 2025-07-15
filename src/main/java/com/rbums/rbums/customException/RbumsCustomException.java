package com.rbums.rbums.customException;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RbumsCustomException extends RuntimeException {
    private String message;
    private HttpStatus status;
    private int code;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public RbumsCustomException(String message, HttpStatus status, int code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
}
