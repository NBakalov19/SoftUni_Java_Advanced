package GenericCustomList;

public class CommandParser {
  private CustomList<String> customList;

  public CommandParser() {
    this.customList = new CustomList<>();
  }

  public void execute(String command) {
    String[] tokens = command.split("\\s+");

    switch (tokens[0]) {
      case "Add":
        this.customList.add(tokens[1]);
        break;
      case "Remove":
        this.customList.remove(Integer.parseInt(tokens[1]));
        break;
      case "Contains":
        System.out.println(this.customList.contains(tokens[1]));
        break;
      case "Swap":
        this.customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        break;
      case "Greater":
        System.out.println(this.customList.greaterThan(tokens[1]));
        break;
      case "Max":
        System.out.println(this.customList.getMax());
        break;
      case "Min":
        System.out.println(this.customList.getMin());
        break;
      case "Sort":
        Sorter.sort(this.customList);
        break;
      default:
        // this.customList.forEach(System.out::println);
        for (String string : customList) {
          System.out.println(string);
        }
        break;
    }
  }
}