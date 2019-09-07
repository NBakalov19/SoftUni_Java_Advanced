package CompanyRoster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfInputs = Integer.parseInt(scanner.nextLine());

    HashMap<String, Department> departments = new HashMap<>();

    for (int i = 0; i < countOfInputs; i++) {
      String[] tokens = scanner.nextLine().split("\\s+");

      String employeeName = tokens[0];
      double employeeSalary = Double.parseDouble(tokens[1]);
      String departmentName = tokens[3];
      Employee employee;

      switch (tokens.length) {
        case 4:
          employee = new Employee(employeeName, employeeSalary);
          break;
        case 5:
          if (tokens[4].contains("@")) {
            String employeeEmail = tokens[4];
            employee = new Employee(employeeName, employeeSalary, employeeEmail);
          } else {
            int employeeAge = Integer.parseInt(tokens[4]);
            employee = new Employee(employeeName, employeeSalary, employeeAge);
          }
          break;
        default:
          String employeeEmail = tokens[4];
          int employeeAge = Integer.parseInt(tokens[5]);
          employee = new Employee(employeeName, employeeSalary, employeeEmail, employeeAge);
          break;
      }

      departments.putIfAbsent(departmentName, new Department(departmentName));
      departments.get(departmentName).getEmployees().add(employee);
    }

    departments.entrySet()
            .stream().
            min((f, s) ->
                    Double.compare(s.getValue().getAverageSalary(), f.getValue().getAverageSalary()))
            .ifPresent(e -> {
              System.out.println("Highest Average Salary: " + e.getKey());
              e.getValue().getEmployees()
                      .stream()
                      .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                      .forEach(employee -> System.out.println(employee.getInfo()));
            });
  }
}