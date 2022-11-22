package dto;

import model.Value;

import java.time.LocalDate;
import java.util.Date;

public class YearlyFinancialReportDto {
    private Value value;
    private String employeeId;
    private String eventDate;
    private Object eventValue;

    public YearlyFinancialReportDto(Value value, String employeeId, String eventDate, Object eventValue) {
        this.value = value;
        this.employeeId = employeeId;
        this.eventDate = eventDate;
        this.eventValue = eventValue;
    }

    @Override
    public String toString() {
        return "YearlyFinancialReportDto{" +
                "value=" + value +
                ", employeeId='" + employeeId + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventValue=" + eventValue +
                '}';
    }
}
