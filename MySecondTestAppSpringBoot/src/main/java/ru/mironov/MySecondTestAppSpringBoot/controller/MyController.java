package ru.mironov.MySecondTestAppSpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.mironov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.mironov.MySecondTestAppSpringBoot.model.*;
import ru.mironov.MySecondTestAppSpringBoot.service.DateTimeUtil;
import ru.mironov.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.mironov.MySecondTestAppSpringBoot.service.ValidateService;

import javax.validation.Valid;
import java.util.Date;

@RestController
@Slf4j
public class MyController {
    private final ValidateService validateService;
    private final ModifyResponseService modifyResponseService;
    @Autowired
    public MyController(ValidateService validateService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validateService = validateService;
        this.modifyResponseService = modifyResponseService;
    }
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) throws UnsupportedCodeException {

        log.info("Received request: {}", request);
        if ("123".equals(request.getUid())) {
            log.error("Received request with uid '123', throwing UnsupportedCodeException");
            throw new UnsupportedCodeException();
        }

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(String.valueOf(Codes.SUCCESS))
                .errorCode(String.valueOf(ErrorCodes.EMPTY))
                .errorMessage(String.valueOf(ErrorMessage.EMPTY))
                .build();

        log.info("Generated response: {}", response);

        try {
            validateService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            log.error("Validation failed: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessage.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An unknown exception occurred: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessage.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        modifyResponseService.modify(response);
        log.info("Modified response: {}", response);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
    @ExceptionHandler(UnsupportedCodeException.class)
    public ResponseEntity<Response> handleUnsupportedCodeException(UnsupportedOperationException ex) {
        Response response = Response.builder()
                .code(String.valueOf(Codes.FAILED))
                .errorCode(String.valueOf(ErrorCodes.UNSUPPORTED_EXCEPTION))
                .errorMessage(String.valueOf(ErrorMessage.valueOf(ex.getMessage())))
                .build();
        log.error("Hand UnsupportedCodeException: ", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ValidationFailedException.class)
    public ResponseEntity<Response> handleValidationFailedException(ValidationFailedException ex) {
        Response response = Response.builder()
                .code(String.valueOf(Codes.FAILED))
                .errorCode(String.valueOf(ErrorCodes.VALIDATION_EXCEPTION))
                .errorMessage(String.valueOf(ErrorMessage.valueOf(ex.getMessage())))
                .build();
        log.error("Handling ValidationFailedException: {}", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
