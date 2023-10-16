package ru.mironov.MySecondTestAppSpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.mironov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.mironov.MySecondTestAppSpringBoot.model.*;
import ru.mironov.MySecondTestAppSpringBoot.service.ModifyRequestService;
import ru.mironov.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.mironov.MySecondTestAppSpringBoot.service.ValidationService;
import ru.mironov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import javax.validation.Valid;
import java.util.Date;

@RestController
@Slf4j
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final ModifyRequestService modifySourceRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemNameRequestService") ModifyRequestService modifyRequestService,
                        @Qualifier("ModifySourceRequestService") ModifyRequestService modifySourceRequestService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.modifySourceRequestService = modifySourceRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(String.valueOf(Codes.SUCCESS))
                .errorCode(String.valueOf(ErrorCodes.EMPTY))
                .errorMessage(String.valueOf(ErrorMessages.EMPTY))
                .build();

        log.info("response: {}", response);

        modifyResponseService.modify(response);

        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(String.valueOf(Codes.FAILED));
            response.setErrorCode(String.valueOf(ErrorCodes.VALIDATION_EXCEPTION));
            response.setErrorMessage(String.valueOf(ErrorMessages.VALIDATION));

            log.error("error response: {} {}", response, bindingResult.getFieldError().getDefaultMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(String.valueOf(Codes.FAILED));
            response.setErrorCode(String.valueOf(ErrorCodes.UNSUPPORTED_EXCEPTION));
            response.setErrorMessage(String.valueOf(ErrorMessages.UNSUPPORTED));

            log.error("error response: {} {}", response, bindingResult.getFieldError().getDefaultMessage());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(String.valueOf(Codes.FAILED));
            response.setErrorCode(String.valueOf(ErrorCodes.UNKNOWN_EXCEPTION));
            response.setErrorMessage(String.valueOf(ErrorMessages.UNKNOWN));

            log.error("response: {} {}", response, bindingResult.getFieldError().getDefaultMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyResponseService.modify(response);
        modifySourceRequestService.modify(request);
        modifyRequestService.modify(request);

        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}
