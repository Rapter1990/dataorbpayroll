package dto;

import model.Value;

public class MonthWiseDto {
    private int month;
    private Value info;
    private int totalEmployees;

    public MonthWiseDto(int month, Value info, int totalEmployees) {
        this.month = month;
        this.info = info;
        this.totalEmployees = totalEmployees;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Value getInfo() {
        return info;
    }

    public void setInfo(Value info) {
        this.info = info;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    @Override
    public String toString() {
        return "MonthWiseDto{" +
                "month=" + month +
                ", info=" + info +
                ", totalEmployees=" + totalEmployees +
                '}';
    }
}
