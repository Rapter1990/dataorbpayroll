package dto;

import java.math.BigDecimal;

public class MonthlySalaryReportDto {
    //Month, Total Salary, Total employees
    private int month;
    private BigDecimal totalSalary;
    private int totalEmployees;

    public MonthlySalaryReportDto() {
    }

    public MonthlySalaryReportDto(int month, BigDecimal totalSalary, int totalEmployees) {
        this.month = month;
        this.totalSalary = totalSalary;
        this.totalEmployees = totalEmployees;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public BigDecimal getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(BigDecimal totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "MonthlySalaryReportDto{" +
                "month=" + month +
                ", totalSalary=" + totalSalary +
                ", totalEmployees=" + totalEmployees +
                '}';
    }


    public static MonthlySalaryReportDto aggregate(MonthlySalaryReportDto initial, MonthlySalaryReportDto next) {
        initial.setTotalSalary(initial.getTotalSalary().add(next.getTotalSalary()));
        initial.setTotalEmployees(initial.getTotalEmployees() + next.getTotalEmployees());
        return initial;
    }
}
