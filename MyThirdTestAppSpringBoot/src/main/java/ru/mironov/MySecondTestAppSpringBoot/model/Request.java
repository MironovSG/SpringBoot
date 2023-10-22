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
    @NotBlank(message = "Уникальный идентификатор сообщения обязателен")
    private String uid;  // Уникальный идентификатор сообщения

    @NotBlank(message = "Уникальный идентификатор операции обязателен")
    private String operationUid;  // Уникальный идентификатор операции
    private String systemName;  // Изменили тип на перечисление Systems

    @NotBlank(message = "Время создания сообщения обязательно")
    private String systemTime;  // Время создания сообщения
    private String source; // Ресурс
    private Positions position;  // Должность
    private Double salary;  // Зарплата
    private Double bonus;  // Коэффициент
    private Integer workDays;  // Дни работы

    @Min(value = 1, message = "Уникальный идентификатор коммуникации должен быть не менее 1")
    @Max(value = 100000, message = "Уникальный идентификатор коммуникации должен быть не более 100000")
    private int communicationId;  // Уникальный идентификатор коммуникации
    private int templateId;
    private int productCode;
    private int smsCode;
    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +  // Изменили тип на перечисление Systems
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
