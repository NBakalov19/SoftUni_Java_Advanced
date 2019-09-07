package Google;

public class Parents {
  private String parentName;
  private String parentBirthday;


  public Parents(String relativeName, String relativeBirthday) {
    this.parentName = relativeName;
    this.parentBirthday = relativeBirthday;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public void setParentBirthday(String parentBirthday) {
    this.parentBirthday = parentBirthday;
  }

  public String getParentName() {
    return parentName;
  }

  public String getParentBirthday() {
    return parentBirthday;
  }

}
