package com.example.vacpaycal.controlles;

import com.example.vacpaycal.models.ResultOfCalculation;
import com.example.vacpaycal.services.MainCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CalculateController {

    private final MainCalculator mainCalculator;

    public CalculateController(MainCalculator mainCalculator) {
        this.mainCalculator = mainCalculator;
    }


    /**
     * даты вписывать по стандарту (YYYY-MM-DD)
     * @param startDate начало отпуска
     * @param endDate конец отпуска
     * @param salary средняя зарплата за 12 месяцев
     * @return сумму отпускных
     */
    @GetMapping("/calculate")
    public String calculate(@RequestHeader String startDate,
                            @RequestHeader String endDate,
                            @RequestHeader double salary) {

        LocalDate startWeekend = LocalDate.parse(startDate);
        LocalDate endWeekend = LocalDate.parse(endDate);
        ResultOfCalculation result = mainCalculator.calculation(startWeekend, endWeekend, salary);

        return "Длительность отпуска (без учета выходных и праздников) - "
                + result.getTrueWeekendDays() +
                " дней. Среднедневной заработок - "
                + result.getAverageDailyEarnings() +
                "₽. Сумма отпускных - "
                + result.getTrueWeekendDays() +
                " * "
                + result.getAverageDailyEarnings() +
                "₽ = "
                + result.getVacationPay() + "₽";
    }
}
