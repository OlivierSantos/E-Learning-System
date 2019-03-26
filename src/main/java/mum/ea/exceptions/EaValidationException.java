package mum.ea.exceptions;

import org.springframework.validation.Errors;

import java.util.List;

public class EaValidationException extends RuntimeException {

    private Errors errors;
    private List<String> messages;

    public EaValidationException() {
    }

    public EaValidationException(Errors errors,List<String> message) {
        this.errors = errors;
        this.messages = message;
    }

    public Errors getErrors() {
        return errors;
    }

    public List<String> getMessages() {
        return messages;
    }
}
