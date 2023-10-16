package ru.mironov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.mironov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.mironov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if(bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
        else if(bindingResult.getFieldValue("uid").equals("123")) {
            throw new UnsupportedCodeException("Код uid '123' не поддерживается");
        }
    }
}
