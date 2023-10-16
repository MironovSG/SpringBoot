package ru.mironov.MySecondTestAppSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "Uid не заполнено")
    private String uid;
    @NotBlank(message = "OperationUid не заполнено")
    private String operationUid;
    private Systems systemName;
    @NotBlank(message = "SystemTime не заполнено")
    private String systemTime;
    private String source;
    @Min(value = 1, message = "CommunicationId не должно быть меньше 1")
    @Max(value = 100000, message = "CommunicationId не должно быть больше 100000")
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;
    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
