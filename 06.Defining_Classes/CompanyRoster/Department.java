package CompanyRoster;

import java.util.ArrayList;

public class Department {
  private String name;
  private ArrayList<Employee> employees;

  public ArrayList<Employee> getEmployees() {
    return this.employees;
  }

  public Department(String name) {
    this.name = name;
    this.employees = new ArrayList<>();
  }

  public Double getAverageSalary() {
    return this.employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .getAsDouble();
  }
}
