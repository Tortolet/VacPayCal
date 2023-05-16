package com.example.vacpaycal.services;

import com.example.vacpaycal.models.ResultOfCalculation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MainCalculator {

    public boolean testWeekend(LocalDate date){
        return date.getDayOfWeek().getValue() != 6 && date.getDayOfWeek().getValue() != 7;
    }

    public ResultOfCalculation calculation(LocalDate startWeekend, LocalDate endWeekend, double salary) {
        ResultOfCalculation resultOfCalculation = new ResultOfCalculation();
        resultOfCalculation.setYearSalary(salary);

        List<LocalDate> weekend = startWeekend.datesUntil(endWeekend.plusDays(1))
                .toList();
        resultOfCalculation.setTotalWeekendDays(weekend.size());
        
        int[] years = new int[2];
        years[0] = startWeekend.getYear();
        years[1] = endWeekend.getYear();

        List<LocalDate> weekendDaysRussia = new ArrayList<>();
        for (int year : years) {

            // Новогодние каникулы
            for (int j = 1; j <= 8; j++) {
                LocalDate testVar = LocalDate.of(year, 1, j);
                if (testWeekend(testVar)) {
                    weekendDaysRussia.add(testVar);
                }
            }

            // День защитника отечества
            LocalDate dayOf23Feb = LocalDate.of(year, 2, 23);
            if (testWeekend(dayOf23Feb)) {
                weekendDaysRussia.add(dayOf23Feb);
            }

            // Международный женский день
            LocalDate dayOf8March = LocalDate.of(year, 3, 8);
            if (testWeekend(dayOf8March)) {
                weekendDaysRussia.add(dayOf8March);
            }

            // Праздник Весны и Труда
            LocalDate dayOf1May = LocalDate.of(year, 5, 1);
            if (testWeekend(dayOf1May)) {
                weekendDaysRussia.add(dayOf1May);
            }

            // День Победы
            LocalDate dayOf9May = LocalDate.of(year, 5, 9);
            if (testWeekend(dayOf9May)) {
                weekendDaysRussia.add(dayOf9May);
            }

            // День России
            LocalDate dayOfRussia = LocalDate.of(year, 6, 12);
            if (testWeekend(dayOfRussia)) {
                weekendDaysRussia.add(dayOfRussia);
            }

            // День народного единства
            LocalDate dayOfNationUnity = LocalDate.of(year, 11, 4);
            if (testWeekend(dayOfNationUnity)) {
                weekendDaysRussia.add(dayOfNationUnity);
            }

            if (years[1] == years[0]) {
                break;
            }
        }

        int weekendDaysTrue = 0;
        for (LocalDate date : weekend) {
            if (!weekendDaysRussia.contains(date) && testWeekend(date)) {
                weekendDaysTrue++;
            }
        }
        resultOfCalculation.setTrueWeekendDays(weekendDaysTrue);

        double averageDailyEarnings = (double) Math.round(salary / 12 / 29.3 * 100) / 100;
        resultOfCalculation.setAverageDailyEarnings(averageDailyEarnings);

        double vacationPay = (double) Math.round(averageDailyEarnings * weekendDaysTrue * 100) / 100; // Расчет суммы отпускных без учета праздников и выходных
        resultOfCalculation.setVacationPay(vacationPay);

        return resultOfCalculation;
    }
}
