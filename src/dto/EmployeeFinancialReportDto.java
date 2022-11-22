package dto;

import model.Employee;

import java.math.BigDecimal;

public class EmployeeFinancialReportDto {
    private String employeeId;
    private String name;
    private String surname;
    private BigDecimal totalAmountPaid;

    public EmployeeFinancialReportDto(String employeeId, String name, String surname, BigDecimal totalAmountPaid) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.totalAmountPaid = totalAmountPaid;
    }

    @Override
    public String toString() {
        return "EmployeeFinancialReportDto{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", totalAmountPaid=" + totalAmountPaid +
                '}';
    }
}
