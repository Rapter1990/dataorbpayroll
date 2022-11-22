package main;

import dto.*;
import model.Employee;
import model.Value;
import utils.ReadValue;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class Main {

    private static Map<String, List<Employee>> employees = new LinkedHashMap<String,List<Employee>>();

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

    public static void main(String[] args) {

        Main main = new Main();

        Instant start = Instant.now();
        employees = readFileProcess();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time Duration: "+ (double) ((timeElapsed.toMillis()/ (double) 1000) / (double) 60) +" seconds");

        System.out.println("-------------------------------------------------------------------------------------");
        // Total number of employees in an organization
        getTotalNumberOfEmployeesInOrganization(); // DONE

        System.out.println("-------------------------------------------------------------------------------------");
        // Month wise following details
        getMonthWiseFollowingDetails(); // DONE

        System.out.println("-------------------------------------------------------------------------------------");
        // Monthly salary report in following format (Month, Total Salary, Total employees)
        main.getMonthlySalaryReport(); // DONE

        System.out.println("-------------------------------------------------------------------------------------");
        // Employee wise financial report in the following format (Employee Id, Name, Surname, Total amount paid)
        getEmployeeWiseFinancialReport(); // DONE

        System.out.println("-------------------------------------------------------------------------------------");
        // Monthly amount released in following format (Month, Total Amount (Salary + Bonus + REIMBURSEMENT), Total employees)
        main.getMonthlyAmountReleasedReport(); // DONE

        System.out.println("-------------------------------------------------------------------------------------");
        // Yearly financial report in the following format (Event, Emp Id, Event Date, Event value)
        getYearlyFinancialReport(); // DONE

    }

    private static Map<String, List<Employee>> readFileProcess() {

        ReadValue.readFile("data.txt");
        employees = ReadValue.getEmployees();
        return employees;
    }

    private static void getTotalNumberOfEmployeesInOrganization() {
        int organizationSize = employees.size();
        System.out.println("Total number of employees in an organization : " + organizationSize);
    }

    private static void getMonthWiseFollowingDetails(){

        DateTimeFormatter onBoardformatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        DateTimeFormatter exitformatter = DateTimeFormatter.ofPattern("d-M-yyyy");

        // ONBOARD
        List<MonthWiseDto > onboardResult = employees.values().stream()
                .flatMap(List::stream)
                .filter(emp -> emp.getEvent() == Value.ONBOARD)
                .collect(Collectors.groupingBy(
                        p -> new MonthWiseGroupDto(LocalDate.parse(p.getValue().toString(), onBoardformatter).getMonthValue(), p.getEvent()),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .map(entry -> new MonthWiseDto(entry.getKey().getMonth(), entry.getKey().getInfo(), (int) (long) entry.getValue()))
                .sorted(Comparator.comparing(MonthWiseDto::getMonth))
                .toList();

        // EXIT
        List<MonthWiseDto > exitResult = employees.values().stream()
                .flatMap(List::stream)
                .filter(emp -> emp.getEvent() == Value.EXIT)
                .collect(Collectors.groupingBy(
                        p -> new MonthWiseGroupDto(LocalDate.parse(p.getValue().toString(), exitformatter).getMonthValue(), p.getEvent()),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .map(entry -> new MonthWiseDto(entry.getKey().getMonth(), entry.getKey().getInfo(), (int) (long) entry.getValue()))
                .sorted(Comparator.comparing(MonthWiseDto::getMonth))
                .toList();

        System.out.println("ONBOARD RESULTS");
        onboardResult.forEach(System.out::println);

        System.out.println("EXIT RESULTS");
        exitResult.forEach(System.out::println);
    }

    private void getMonthlySalaryReport(){

        List<MonthlySalaryReportDto> group = employees.values().stream()
                .flatMap(List::stream)
                .filter(emp -> emp.getEvent() == Value.SALARY)
                .collect(Collectors.groupingBy(p -> p.getEventDate().getMonthValue()))
                .entrySet().stream()
                .map(this::toReport)
                .collect(toList());

        System.out.println("MONTHLY SALARY REPORT");
        group.forEach(System.out::println);
    }

    private static void getEmployeeWiseFinancialReport(){

        List<EmployeeFinancialReportDto> totalSalary = employees.values().stream()
                .map(l -> l.stream()
                        .filter(emp -> emp.getEvent() == Value.SALARY)
                        .map(employee -> new BigDecimal(employee.getValue().toString()))
                        .collect(Collectors.collectingAndThen(
                                Collectors.reducing(BigDecimal::add),
                                salary -> new EmployeeFinancialReportDto(l.get(0).getEmpID(),
                                        l.get(0).getEmpFName(),
                                        l.get(0).getEmpLName(),
                                        salary.orElseThrow())
                        ))
                ).toList();

        System.out.println("EMPLOYEE WISE FINANCIAL REPORT");
        totalSalary.forEach(System.out::println);
    }

    private void getMonthlyAmountReleasedReport(){

        List<MonthlySalaryReportDto> result = employees.values().stream()
                .flatMap(List::stream)
                .filter(emp -> emp.getEvent() == Value.SALARY || emp.getEvent() == Value.BONUS
                        || emp.getEvent() == Value.REIMBURSEMENT)
                .collect(Collectors.groupingBy(
                        e -> e.getEventDate().getMonthValue(),
                        Collectors.teeing(
                                Collectors.mapping(Employee::getEmpID, Collectors.toSet()),
                                Collectors.reducing(
                                        PersonGroupMetric.EMPTY,
                                        PersonGroupMetric::new,
                                        PersonGroupMetric::add
                                ),
                                (set, metric) -> new MonthlySalaryReportDto(
                                        metric.getMonth(),
                                        metric.getSum(),
                                        set.size() // the number of unique ids
                                )
                        )
                ))
                .values().stream().toList();

        System.out.println("MONTHLY AMOUNT RELEASED REPORT");
        result.forEach(System.out::println);
    }

    public MonthlySalaryReportDto toReport(Map.Entry<Integer, List<Employee>> entry) {
        int month = entry.getKey();
        int totalEmployees = entry.getValue().size();
        BigDecimal totalSalary = entry.getValue().stream()
                .map(employee -> new BigDecimal(employee.getValue().toString()) )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        MonthlySalaryReportDto report = new MonthlySalaryReportDto(month,totalSalary,totalEmployees);
        return report;
    }

    private static void getYearlyFinancialReport(){

        List<YearlyFinancialReportDto> yearlyFinancialReportDtos = employees.values().stream()
                .flatMap(List::stream).map(employee ->
                        new YearlyFinancialReportDto(employee.getEvent(),employee.getEmpID(),formatter.format(employee.getEventDate())
                                ,employee.getValue()))
                .collect(toList());

        System.out.println("YEARLY FINANCIAL REPORT");
        yearlyFinancialReportDtos.forEach(System.out::println);

    }

}
