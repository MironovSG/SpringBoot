package ru.mironov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.mironov.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Service
public interface ValidateService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
