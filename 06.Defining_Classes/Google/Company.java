package Google;

public class Company {
  private String companyName;
  private String department;
  private Double salary;

  public String getCompanyName() {
    return companyName;
  }

  public String getDepartment() {
    return department;
  }

  public Double getSalary() {
    return salary;
  }

  public Company(String companyName, String department, Double salary) {
    this.companyName = companyName;
    this.department = department;
    this.salary = salary;
  }
}
