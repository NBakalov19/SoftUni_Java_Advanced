package CompanyRoster;

class Employee {

  private String name;
  private double salary;
  private String email;
  private int age;

  private static final String UNDEFINED_EMAIL = "n/a";
  public static final Integer UNDEFINED_AGES = -1;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSalary() {
    return this.salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
    this.email = Employee.UNDEFINED_EMAIL;
    this.age = Employee.UNDEFINED_AGES;
  }

  public Employee(String name, double salary, String email) {
    this(name, salary);
    this.email = email;
  }

  public Employee(String name, double salary, int age) {
    this(name, salary);
    this.age = age;
  }

  public Employee(String name, double salary, String email, int age) {
    this(name, salary, email);
    this.age = age;
  }

  public String getInfo() {
    return String.format("%s %.2f %s %d",
            this.name, this.salary, this.email, this.age);
  }
}