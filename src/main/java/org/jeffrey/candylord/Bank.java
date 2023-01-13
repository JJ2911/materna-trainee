package org.jeffrey.candylord;

/**
 * @author Jeffrey Liew
 */
public class Bank {
  private final double INTEREST_RATE = 5.5;
  private int balance = 0;

  public Bank() {
  }

  /**
   * Returns the balance.
   *
   * @return the balance
   */
  public int getBalance() {
    return balance;
  }

  /**
   * Adds interest to the balance.
   */
  public void calculateBalance() {
    if (balance > 0) {
      balance *= INTEREST_RATE / 100 + 1;
    }
  }

  /**
   * Deposit cash to the player's bank.
   *
   * @param player Player that deposits cash
   * @param amount the amount
   */
  public void deposit(Player player, int amount) {
    if (!City.Location.isInBronx(player)) {
      System.out.println("The bank is located in the bronx.");
      return;
    }

    if (amount < 1) {
      System.out.println("The amount needs to be greater than 0.");
      return;
    }

    if (amount > player.getCash()) {
      System.out.printf("You don't have $%d in cash.%n", amount);
    } else {
      player.setCash(player.getCash() - amount);
      balance += amount;
      System.out.printf("Your deposit of $%d was successful.%n", amount);
    }
  }

  /**
   * Withdraw cash from the player's bank.
   *
   * @param player Player that withdraws cash
   * @param amount the amount
   */
  public void withdraw(Player player, int amount) {
    if (!City.Location.isInBronx(player)) {
      System.out.println("The bank is located in the bronx.");
      return;
    }

    if (amount < 1) {
      System.out.println("The amount needs to be greater than 0.");
      return;
    }

    if (amount > balance) {
      System.out.printf("You don't have $%d in your balance.%n", amount);
    } else {
      player.setCash(player.getCash() + amount);
      balance -= amount;
      System.out.printf("Your withdrawal of $%d was successful.%n", amount);
    }
  }
}
