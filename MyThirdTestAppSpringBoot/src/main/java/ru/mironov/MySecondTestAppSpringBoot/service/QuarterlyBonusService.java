package ru.mironov.MySecondTestAppSpringBoot.service;
import ru.mironov.MySecondTestAppSpringBoot.model.Positions;
public interface QuarterlyBonusService {
    double calculate(Positions position, double salary, double bonus);
}
