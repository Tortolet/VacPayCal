package com.example.vacpaycal;

import com.example.vacpaycal.models.ResultOfCalculation;
import com.example.vacpaycal.services.MainCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
class VacPayCalApplicationTests {


    @Autowired
    private MainCalculator mainCalculator;


    @Test
    void testWeekends() {
        LocalDate start = LocalDate.of(2023, Month.JUNE, 14);
        LocalDate end = LocalDate.of(2023, Month.JUNE, 26);

        ResultOfCalculation result = new ResultOfCalculation(13, 9, 720000.0, 2047.78, 18430.02);
        ResultOfCalculation expected = mainCalculator.calculation(start, end, 720000);

        Assertions.assertEquals(expected.getVacationPay(), result.getVacationPay());
        System.out.println("Данные верны");
    }
}
