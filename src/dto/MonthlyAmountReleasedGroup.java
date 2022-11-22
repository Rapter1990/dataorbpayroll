package dto;

import model.Value;

public class MonthlyAmountReleasedGroup {
    private int month;

    private Value statement;

    private String empId;

    public MonthlyAmountReleasedGroup(int month, String empId, Value statement) {
        this.month = month;
        this.empId = empId;
        this.statement = statement;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Value getStatement() {
        return statement;
    }

    public void setStatement(Value statement) {
        this.statement = statement;
    }
}
