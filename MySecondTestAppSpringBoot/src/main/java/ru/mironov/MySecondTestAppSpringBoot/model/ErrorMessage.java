package ru.mironov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessage {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNKNOWN("Неподдерживаемая ошибка"),
    UNSUPPORTED("Неизвестная ошибка");
    private final String description;
    ErrorMessage(String description) {
        this.description = description;
    }
    @JsonValue
    public String getName() {
        return description;
    }
}

