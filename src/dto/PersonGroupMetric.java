package dto;

import model.Employee;

import java.math.BigDecimal;

public class PersonGroupMetric {

    public static final PersonGroupMetric EMPTY = new PersonGroupMetric(0, BigDecimal.ZERO, -1);

    private int count;
    private BigDecimal sum;
    private int month;

    public PersonGroupMetric(int count, BigDecimal sum, int month) {
        this.count = count;
        this.sum = sum;
        this.month = month;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public PersonGroupMetric(Employee e) {
        this(1, new BigDecimal(e.getValue().toString()), e.getEventDate().getMonthValue());
    }

    public PersonGroupMetric add(PersonGroupMetric other) {
        return new PersonGroupMetric(
                this.count + other.count,
                this.sum.add(other.sum),
                this.month
        );
    }
}
