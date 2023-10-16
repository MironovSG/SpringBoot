package ru.mironov.MySecondTestAppSpringBoot.model;
import com.fasterxml.jackson.annotation.JsonValue;
public enum Systems {
    EMPTY (""),
    ERP ("Планирование ресурсов"),
    CRM ("Customer Relationship Management"),
    WMS ("Warehouse Management System"),
    S1 ("Service 1");
    private final String name;
    Systems(String name) {
        this.name = name;
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

