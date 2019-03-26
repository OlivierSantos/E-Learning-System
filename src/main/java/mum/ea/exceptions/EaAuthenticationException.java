package mum.ea.exceptions;

import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.Errors;

import java.util.List;

public class EaAuthenticationException extends AuthenticationException {

    private String message;

    public EaAuthenticationException(String msg) {
        super(msg);
        this.message=msg;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
