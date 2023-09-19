package ru.mironov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Response {
    private String uid;
    private String operationUid;
    private String systemTime;
    private String code;
    private String errorCode;
    private String errorMessage;

    public void setCode(Codes codes) {

    }

    public void setErrorCode(ErrorCodes errorCodes) {

    }

    public void setErrorMessage(ErrorMessage errorMessage) {

    }
}
