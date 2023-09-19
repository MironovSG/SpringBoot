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
    @NotBlank(message = "Уникальный идентификатор сообщения")
    @Size(max = 32, message = "Уникальный идентификатор сообщения не более 32 символов")
    private String uid;

    @NotBlank(message = "Уникальный идентификатор операции")
    @Size(max = 32, message = "Уникальный идентификатор операции не более 32 символов")
    private String operationUid;

    @NotBlank(message = "Время создания сообщения")
    private String systemTime;

    @Min(value = 1, message = "Уникальный идентификатор коммуникации не менее 1")
    @Max(value = 100000, message = "Уникальный идентификатор коммуникации не более 100000")
    private int communicationId;

    private String systemName;
    private String source;
    private int templateId;
    private int productCode;
    private int smsCode;

    @Override
    public String toString() {
        return " " +
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
