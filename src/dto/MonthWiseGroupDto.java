package dto;

import model.Value;

public class MonthWiseGroupDto {

    private int month;
    private Value info;

    public MonthWiseGroupDto(int month, Value info) {
        this.month = month;
        this.info = info;
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
}
