package org.jeffrey.candylord;

public class LoanShark {
  public static final double INTEREST_RATE = 10;
  private final int MINIMUM_LOAN = 1000;
  private final int MAXIMUM_LOAN = 10_000;

  public LoanShark() {
  }

  public void getLoan(Player player, int amount) {
    if (!City.Location.isInBronx(player)) {
      System.out.println("The loan shark is in the Bronx.");
      return;
    }

    if (player.getDebt() > 0) {
      System.out.printf("You still owe me $%d.%n", player.getDebt());
      return;
    }

    if (amount < MINIMUM_LOAN) {
      System.out.printf("I got a $%d minimum.%n", MINIMUM_LOAN);
    } else if (amount > MAXIMUM_LOAN) {
      System.out.printf("I got a $%d maximum.%n", MAXIMUM_LOAN);
    } else {
      player.setCash(player.getCash() + amount);
      player.setDebt(amount);
      System.out.printf("You got a $%d loan.%n", amount);
    }
  }

  public void payOffLoan(Player player, int amount) {
    if (!City.Location.isInBronx(player)) {
      System.out.println("The loan shark is in the Bronx.");
      return;
    }

    int playerDebt = player.getDebt();
    int playerCash = player.getCash();

    if (playerDebt == 0) {
      System.out.println("You don't owe me anything.");
      return;
    }

    if (amount < 1) {
      System.out.println("The amount needs to be greater than 0.");
      return;
    }

    if (amount > playerCash) {
      System.out.printf("You don't have $%d in cash.%n", amount);
      return;
    }

    if (amount >= playerDebt) {
      player.setCash(playerCash - playerDebt);
      player.setDebt(0);
      System.out.println("You paid off your debt.");
    } else {
      player.setCash(playerCash - amount);
      player.setDebt(playerDebt - amount);
      System.out.printf("You still owe me $%d.%n", player.getDebt());
    }
  }
}
