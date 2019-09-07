package arena;

public class Main {
  public static void main(String[] args) {
    //Creates fightingArena
    FightingArena fightingArena = new FightingArena("Armeec");

//Creates stats
    Stat firstGladiatorStat = new Stat(20, 25, 35, 14, 48);
    Stat secondGladiatorStat = new Stat(40, 40, 40, 40, 40);
    Stat thirdGladiatorStat = new Stat(20, 25, 35, 14, 48);

//Creates weapons
    Weapon firstGladiatorWeapon = new Weapon(5, 28, 100);
    Weapon secondGladiatorWeapon = new Weapon(5, 28, 100);
    Weapon thirdGladiatorWeapon = new Weapon(50, 50, 50);

//Creates gladiators
    Gladiator firstGladiator = new Gladiator("Stoyan", firstGladiatorStat, firstGladiatorWeapon);
    Gladiator secondGladiator = new Gladiator("Pesho", secondGladiatorStat, secondGladiatorWeapon);
    Gladiator thirdGladiator = new Gladiator("Author", thirdGladiatorStat, thirdGladiatorWeapon);

//Adds gladiators to fightingArena
    fightingArena.add(firstGladiator);
    fightingArena.add(secondGladiator);
    fightingArena.add(thirdGladiator);

//Prints gladiators count at the fightingArena
    System.out.println(fightingArena.getCount());

//Gets strongest gladiator and print him
    Gladiator strongestGladiator = fightingArena.getGladiatorWithHighestTotalPower();
    System.out.println(strongestGladiator);

//Gets gladiator with the strongest weapon and print him
    Gladiator bestWeaponGladiator = fightingArena.getGladiatorWithHighestWeaponPower();
    System.out.println(bestWeaponGladiator);

//Gets gladiator with the strongest stat and print him
    Gladiator bestStatGladiator = fightingArena.getGladiatorWithHighestStatPower();
    System.out.println(bestStatGladiator);

//Removes gladiator
    fightingArena.remove("Author");

//Prints gladiators count at the fightingArena
    System.out.println(fightingArena.getCount());

//Prints the fightingArena
    System.out.println(fightingArena);

  }
}
