package ru.mironov.MySecondTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.mironov.MySecondTestAppSpringBoot.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuarterlyBonusServiceImplTest {
    @Test
    void calculateQuarterlyBonusForManager() {
        //given
        Positions position = Positions.MANAGER;
        double bonus = 0.2; // 20% от зарплаты
        double salary = 70000.0; // Зарплата
        //when
        double result = new QuarterlyBonusServiceImpl().calculate(position, salary, bonus);
        //then
        double expected = 840000.0;
    }
    @Test
    void calculateQuarterlyBonusForNonManager() {
        //given
        Positions position = Positions.DEV;
        double bonus = 0.1; // 10% от зарплаты
        double salary = 55000.0; // Зарплата

        //when
        double result = new QuarterlyBonusServiceImpl().calculate(position, salary, bonus);

        //then
        double expected = 0.0;
        assertThat(result).isEqualTo(expected);
    }
}