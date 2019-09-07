import java.util.*;
import java.util.stream.Collectors;

public class Vlog {
  public static class Vlogger {
    private String name;
    private Set<Vlogger> followers;
    private Set<Vlogger> following;

    public Vlogger(String name) {
      this.name = name;
      this.followers = new HashSet<>();
      this.following = new HashSet<>();
    }

    public String getName() {
      return name;
    }

    public int getFollowersCount() {
      return this.followers.size();
    }

    public int getFollowingCount() {
      return this.following.size();
    }

    public void follow(Vlogger vlogger) {
      if (vlogger == this) {
        return;
      }
      this.followers.add(vlogger);
    }

    public void addFollowing(Vlogger vlogger) {
      if (vlogger == this) {
        return;
      }
      this.following.add(vlogger);
    }

    public String toFullString() {
      StringBuilder sb = new StringBuilder();
      sb.append(this.toBasicString()).append("\n");

      List<Vlogger> sortedVloggers = this.followers
              .stream()
              .sorted(Comparator.comparing(Vlogger::getName))
              .collect(Collectors.toList());

      for (Vlogger follower : sortedVloggers) {
        sb.append("*  ").append(follower.getName()).append("\n");
      }

      return sb.toString();
    }

    public String toBasicString() {
      return String.format("%s : %d followers, %d following",
              getName(),
              getFollowersCount(),
              getFollowingCount());
    }
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Map<String, Vlogger> vloggers = new HashMap<>();
    String input = scanner.nextLine();

    while (!input.equals("Statistics")) {
      String[] tokens = input.split("\\s+");

      if (tokens[1].equals("joined")) {
        vloggers.putIfAbsent(tokens[0], new Vlogger(tokens[0]));
      } else {
        Vlogger follower = vloggers.get(tokens[0]);
        Vlogger followed = vloggers.get(tokens[2]);

        if (follower == null || followed == null) {
          input = scanner.nextLine();
          continue;
        }

        followed.follow(follower);
        follower.addFollowing(followed);

        vloggers.put(followed.getName(), followed);
        vloggers.put(follower.getName(), follower);

      }
      input = scanner.nextLine();
    }

    List<Vlogger> sortedVloggers = vloggers.values()
            .stream()
            .sorted((f, s) -> {
              int diff = s.getFollowersCount() - f.getFollowersCount();
              if (diff == 0) {
                diff = f.getFollowingCount() - s.getFollowingCount();
              }
              return diff;
            })
            .collect(Collectors.toList());

    System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vloggers.size());
    System.out.printf("1. %s", sortedVloggers.get(0).toFullString());

    for (int i = 1; i < sortedVloggers.size(); i++) {
      System.out.printf("%d. %s%n",
              i + 1,
              sortedVloggers.get(i).toBasicString());
    }
  }
}