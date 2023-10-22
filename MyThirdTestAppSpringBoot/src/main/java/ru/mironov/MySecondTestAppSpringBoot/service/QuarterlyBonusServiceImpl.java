package ru.mironov.MySecondTestAppSpringBoot.service;
import org.springframework.stereotype.Service;
import ru.mironov.MySecondTestAppSpringBoot.model.Positions;
@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService{
    @Override
    public double calculate(Positions position, double salary, double bonus) {
        // Проверка позиции на isManager
        if (position.isManager()) {
            // Вычисление квартальной премии для позиций isManager, допустим 20 %
            double annualBonus = salary * bonus * 365 * position.getPositionCoefficient() / 365; // Годовой бонус
            return annualBonus * 0.2;
        } else {
            // Если позиция не isManager, возвращаем 0
            return 0.0;
        }
    }
}

