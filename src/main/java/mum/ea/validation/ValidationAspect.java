package mum.ea.validation;

import mum.ea.domain.Member;
import mum.ea.exceptions.EaValidationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class ValidationAspect {

    @Autowired
    private Validator validator;

    @Autowired
    MessageSourceAccessor messageAccessor;

    @Pointcut("@annotation(EaValidate)")
    public void annotation() {
    }

    @Pointcut("args(object)")
    public void args(Object object) {
    }


    @Before("annotation() && args(object)")
    public void doValidate(Object object) {

//        boolean isMember = false;
//        Member m =null;
//        try {
//            m = (Member) object;
//            isMember = true;
//        } catch (Exception e) {
//            isMember = false;
//        }
//
//        if(isMember){
//            if(m.isForBatch()){
//                javax.validation.Validator groupValidator = Validation.buildDefaultValidatorFactory().getValidator();
//                Set<ConstraintViolation<Object>> errors = groupValidator.validate(object, StandardGroup.class);
//                Boolean validationSuccess = errors.size() == 0 ? true : false;
//                if (!validationSuccess){
//                    List<String> messages = new ArrayList<String>();
//                    messages.add("Validation Failed");
//                    throw new EaValidationException(null,messages);
//                }
//            }
//        }


        Errors errors = new BeanPropertyBindingResult(object, object.getClass().getName());

        validator.validate(object, errors);

        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            List<String> messages = new ArrayList<String>();
            for (FieldError fieldError : fieldErrors) {
                messages.add(messageAccessor.getMessage(fieldError));

            }
            throw new EaValidationException(errors, messages);
        }

        return;
    }


}
