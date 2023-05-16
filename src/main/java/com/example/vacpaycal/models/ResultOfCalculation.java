package com.example.vacpaycal.models;

public class ResultOfCalculation {
    private int totalWeekendDays;
    private int trueWeekendDays;
    private double yearSalary;
    private double averageDailyEarnings;
    private double vacationPay;

    public ResultOfCalculation() {
    }

    public ResultOfCalculation(int totalWeekendDays, int trueWeekendDays, double yearSalary, double averageDailyEarnings, double vacationPay) {
        this.totalWeekendDays = totalWeekendDays;
        this.trueWeekendDays = trueWeekendDays;
        this.yearSalary = yearSalary;
        this.averageDailyEarnings = averageDailyEarnings;
        this.vacationPay = vacationPay;
    }

    public int getTotalWeekendDays() {
        return totalWeekendDays;
    }

    public void setTotalWeekendDays(int totalWeekendDays) {
        this.totalWeekendDays = totalWeekendDays;
    }

    public int getTrueWeekendDays() {
        return trueWeekendDays;
    }

    public void setTrueWeekendDays(int trueWeekendDays) {
        this.trueWeekendDays = trueWeekendDays;
    }

    public double getYearSalary() {
        return yearSalary;
    }

    public void setYearSalary(double yearSalary) {
        this.yearSalary = yearSalary;
    }

    public double getAverageDailyEarnings() {
        return averageDailyEarnings;
    }

    public void setAverageDailyEarnings(double averageDailyEarnings) {
        this.averageDailyEarnings = averageDailyEarnings;
    }

    public double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    @Override
    public String toString() {
        return "ResultOfCalculation{" +
                "totalWeekendDays=" + totalWeekendDays +
                ", trueWeekendDays=" + trueWeekendDays +
                ", yearSalary=" + yearSalary +
                ", averageDailyEarnings=" + averageDailyEarnings +
                ", vacationPay=" + vacationPay +
                '}';
    }
}
