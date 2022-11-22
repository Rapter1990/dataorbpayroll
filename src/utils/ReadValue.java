package utils;

import model.Employee;
import model.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadValue {

    private static Map<String, List<Employee>> employees = new LinkedHashMap<String,List<Employee>>();

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
    public static void readFile(String fileLocation) {

        fileLocation = "src/files/" + fileLocation;
        String line = "";
        String employeeId = "";
        Employee employee = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {


            while (( line = br.readLine()) != null) {
                String[] personalInformation =  line.split(", ");

                employeeId = personalInformation[1];

                List<Employee> employeeList = employees.get(employeeId);

                if (employeeList == null){
                    employeeList = new ArrayList<>();
                }

                if(personalInformation[5].equals("ONBOARD")) {

                    employee = new Employee();
                    employee.setEmpID(employeeId);
                    employee.setEmpFName(personalInformation[2]);
                    employee.setEmpLName(personalInformation[3]);
                    employee.setDesignation(personalInformation[4]);
                    employee.setEvent(Value.valueOf(personalInformation[5]));
                    employee.setValue(LocalDate.parse(personalInformation[6], formatter));
                    employee.setEventDate(LocalDate.parse(personalInformation[7], formatter));
                    employee.setNotes(personalInformation[8]);

                }
                else { // ONBOARD,SALARY,BONUS,EXIT,REIMBURSEMENT

                    employee = new Employee();
                    employee.setEmpID(personalInformation[1]);
                    employee.setEvent(Value.valueOf(personalInformation[2]));
                    employee.setValue(personalInformation[3]);
                    employee.setEventDate(LocalDate.parse(personalInformation[4], formatter));
                    employee.setNotes(personalInformation[5]);

                }

                employeeList.add(employee);
                employees.put(employeeId,employeeList);
            }

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(fileLocation + " not found");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("IO Error");
        }  finally {
            System.out.println("The process is over");
        }
    }

    public static Map<String,List<Employee>> getEmployees() {
        return employees;
    }
}
