package ru.mironov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Positions {
    DEV ("Developer", 2.2, false),
    HR ("HR",1.2, false),
    TL("TL Manager",2.6, true),
    QA("QA-engineer",2.0, false), // QA-инженер
    MARKETING("Marketing specialist",1.8, false), // Маркетолог
    MANAGER ("Manager specialist", 1.8, true); // Менеджер

    private final String name;
    private final double positionCoefficient;
    private final boolean isManager;
    Positions(String name, double positionCoefficient, boolean isManager) {
        this.name = name;
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
    @JsonValue
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}

