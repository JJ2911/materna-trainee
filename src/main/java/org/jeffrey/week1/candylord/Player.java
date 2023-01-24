package org.jeffrey.week1.candylord;

import org.jeffrey.week1.candylord.event.RandomGameEvents;

import java.util.ArrayList;
import java.util.List;

/**
 * The player can buy or sell candies and travel to other cities.
 *
 * @author Jeffrey Liew
 */
public class Player {
  private final int MAX_CANDIES = 100;
  private int cash = 2_000;
  private int debt = 0;
  private int day = 1;
  private final City city = new City(City.Location.BRONX);
  private final Bank bank = new Bank();
  private final Stash stash = new Stash();
  private final List<Candy> candies = new ArrayList<>();

  public Player() {
  }

  /**
   * Returns the player's candy holding limit.
   *
   * @return the candy limit
   */
  public int getMAX_CANDIES() {
    return MAX_CANDIES;
  }

  /**
   * Returns the player's cash amount.
   *
   * @return the cash amount
   */
  public int getCash() {
    return cash;
  }

  /**
   * Sets the player's cash amount.
   *
   * @param cash new cash amount
   */
  public void setCash(int cash) {
    this.cash = cash;
  }

  /**
   * Returns the player's debt.
   *
   * @return the debt
   */
  public int getDebt() {
    return debt;
  }

  /**
   * Sets the player's debt.
   *
   * @param debt new debt amount
   */
  public void setDebt(int debt) {
    this.debt = debt;
  }

  /**
   * Returns the current day.
   *
   * @return the day
   */
  public int getDay() {
    return day;
  }

  /**
   * Sets the player's current day.
   *
   * @param day new day
   */
  public void setDay(int day) {
    this.day = day;
  }

  /**
   * Returns the player's city.
   *
   * @return the city
   */
  public City getCity() {
    return city;
  }

  /**
   * Returns the player's bank.
   *
   * @return the bank
   */
  public Bank getBank() {
    return bank;
  }

  /**
   * Returns the player's stash.
   *
   * @return the stash
   */
  public Stash getStash() {
    return stash;
  }

  /**
   * Returns the player's candies as a list.
   *
   * @return the list of candies
   */
  public List<Candy> getCandies() {
    return candies;
  }

  /**
   * Adds a candy to the player's list.
   *
   * @param candyType Type of candy
   * @param quantity Candy quantity
   * @param price Candy price
   */
  public void buy(Candy.CandyType candyType, int quantity, int price) {
    if (quantity < 1) {
      System.out.println("Quantity must be greater than 0.");
      return;
    }

    if (sufficientStorage(quantity)) {
      if (quantity * price <= cash) {
        cash -= quantity * price;

        Candy candy = getCandy(candyType);

        if (candy != null) {
          candy.setQuantity(candy.getQuantity() + quantity);
        } else {
          candies.add(new Candy(candyType, quantity));
        }

        System.out.printf(
                "Your purchase of %d %s was successful.%n",
                quantity,
                candyType.getName()
        );
      } else {
        System.out.println("Insufficient funds.");
      }
    } else {
      System.out.println("Not enough space available.");
    }
  }

  /**
   * Removes a candy from the player's list.
   *
   * @param candyType Type of candy
   * @param quantity Candy quantity
   * @param price Candy price
   */
  public void sell(Candy.CandyType candyType, int quantity, int price) {
    if (quantity < 1) {
      System.out.println("Quantity must be greater than 0.");
      return;
    }

    Candy candy = getCandy(candyType);

    if (candy != null) {
      if (quantity <= candy.getQuantity()) {
        candy.setQuantity(candy.getQuantity() - quantity);
        cash += quantity * price;
        System.out.printf("Your sale of %d %s was successful.%n", quantity, candy.getName());

        if (candy.getQuantity() == 0) {
          candies.remove(candy);
        }
      } else {
        System.out.printf("Not enough %s on hand.%n", candy.getName());
      }
    } else {
      System.out.printf("You don't have %s.%n", candyType.getName());
    }
  }

  /**
   * Sets the player's new location.
   *
   * @param location the location to travel to
   * @param price the travel price
   */
  public void travelTo(City.Location location, int price) {
    if (city.getLocation() == location) {
      System.out.printf("You're already in %s.%n", location());
      return;
    }

    if (price <= cash) {
      city.setLocation(location);
      cash -= price;
      day += 1;
      bank.calculateBalance();
      debt *= LoanShark.INTEREST_RATE / 100 + 1;
      RandomGameEvents.next().process(this);
    } else {
      System.out.println("Insufficient funds.");
    }
  }

  /**
   * Returns a boolean checking if the quantity to be added does not exceed <code>MAX_CANDIES</code>.
   *
   * @param quantity the quantity
   * @return <code>true</code> if less than or equal to <code>MAX_CANDIES</code> else <code>false</code>
   */
  private boolean sufficientStorage(int quantity) {
    return sumOfCandies() + quantity <= MAX_CANDIES ? true : false;
  }

  /**
   * Returns a specific candy from the player's list.
   *
   * @param candyType Type of candy
   * @return a specific candy otherwise <code>null</code>
   */
  public Candy getCandy(Candy.CandyType candyType) {
    for (Candy candy : candies) {
      if (candy.getCandyType() == candyType) {
        return candy;
      }
    }

    return null;
  }

  /**
   * Returns a specific candy quantity from the player's list.
   *
   * @param candyType Type of candy
   * @return the candy quantity otherwise <code>0</code>
   */
  public int getCandyQuantity(Candy.CandyType candyType) {
    Candy candy = getCandy(candyType);

    return candy == null ? 0 : candy.getQuantity();
  }

  /**
   * Returns the amount of candies the player is holding.
   *
   * @return the sum of candies
   */
  public int sumOfCandies() {
    int sum = 0;

    for (Candy candy : candies) {
      sum += candy.getQuantity();
    }

    return sum;
  }

  /**
   * Returns the player's holding limit.
   *
   * @return the limit
   */
  public int limit() {
    return MAX_CANDIES;
  }

  /**
   * Returns the player's current city name.
   *
   * @return the city name
   */
  public String location() {
    return city.getName();
  }
}
