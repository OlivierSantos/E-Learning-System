package mum.ea.exceptions;


import com.sun.xml.internal.ws.server.UnsupportedMediaException;
import mum.ea.enums.StatusCode;
import mum.ea.model.EaResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EaValidationException.class)
    public ResponseEntity<?> validationException(EaValidationException ex) {
        EaResult result = new EaResult();
        result.setStatusCode(StatusCode.VALIDATION_ERROR);
        if (ex.getMessages() != null && !ex.getMessages().isEmpty()) {
            result.setMessage(ex.getMessages().get(0));
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @ExceptionHandler(EaAuthenticationException.class)
    public ResponseEntity<?> authenticationException(AuthenticationException ex) {
        EaResult result = new EaResult();
        result.setStatusCode(StatusCode.AUTHENTICATION_ERROR);
        return new ResponseEntity(result, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDeniedException(AccessDeniedException ex) {
        EaResult result = new EaResult();
        result.setStatusCode(StatusCode.AUTHORIZATION_ERROR);
        return new ResponseEntity(result, HttpStatus.UNAUTHORIZED);
    }

//    @ExceptionHandler(Exception.class)
//    public void aa(Exception a) {
//        int aa = 5;
//    }


}
