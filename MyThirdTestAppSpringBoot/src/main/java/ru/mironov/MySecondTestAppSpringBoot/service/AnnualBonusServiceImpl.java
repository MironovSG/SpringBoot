package ru.mironov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Positions;
@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        // Определени високосного года или нет
        int currentYear = java.time.Year.now().getValue();
        boolean isLeapYear = java.time.Year.isLeap(currentYear);

        // Соответствующее количество дней в году
        int daysInYear = isLeapYear ? 366 : 365;

        // Вычисление бонуса, путем простого перемножения на количество дней в году
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }
}


