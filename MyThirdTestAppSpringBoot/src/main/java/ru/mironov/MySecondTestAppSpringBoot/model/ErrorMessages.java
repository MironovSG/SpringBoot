package ru.mironov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNKNOWN("Неподдерживаемая ошибка"),
    UNSUPPORTED("Неизвестная ошибка");
    private final String description;
    ErrorMessages(String description) {
        this.description = description;
    }
    @JsonValue
    public String getName() {
        return description;
    }
}

