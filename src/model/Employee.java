package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee {

    private String empID;
    private String empFName;
    private String empLName;
    private String designation;
    private Value event;

    private Object value;
    private LocalDate eventDate;
    private String notes;

    public Employee() {
    }

    public Employee(String empID, String empFName, String empLName, String designation, Value event, Object value, LocalDate eventDate, String notes) {
        this.empID = empID;
        this.empFName = empFName;
        this.empLName = empLName;
        this.designation = designation;
        this.event = event;
        this.value = value;
        this.eventDate = eventDate;
        this.notes = notes;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpFName() {
        return empFName;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName;
    }



    public Value getEvent() {
        return event;
    }

    public void setEvent(Value event) {
        this.event = event;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empID, employee.empID) && Objects.equals(empFName, employee.empFName) && Objects.equals(empLName, employee.empLName) && Objects.equals(designation, employee.designation) && event == employee.event && Objects.equals(value, employee.value) && Objects.equals(eventDate, employee.eventDate) && Objects.equals(notes, employee.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empFName, empLName, designation, event, value, eventDate, notes);
    }
}
