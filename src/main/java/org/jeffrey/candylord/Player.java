package org.jeffrey.candylord;

import org.jeffrey.candylord.event.RandomGameEvents;

import java.util.ArrayList;
import java.util.List;

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

  public int getMAX_CANDIES() {
    return MAX_CANDIES;
  }

  public int getCash() {
    return cash;
  }

  public void setCash(int cash) {
    this.cash = cash;
  }

  public int getDebt() {
    return debt;
  }

  public void setDebt(int debt) {
    this.debt = debt;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public City getCity() {
    return city;
  }

  public Bank getBank() {
    return bank;
  }

  public Stash getStash() {
    return stash;
  }

  public List<Candy> getCandies() {
    return candies;
  }

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

  private boolean sufficientStorage(int quantity) {
    return sumOfCandies() + quantity <= MAX_CANDIES ? true : false;
  }

  public Candy getCandy(Candy.CandyType candyType) {
    for (Candy candy : candies) {
      if (candy.getCandyType() == candyType) {
        return candy;
      }
    }

    return null;
  }

  public int getCandyQuantity(Candy.CandyType candyType) {
    Candy candy = getCandy(candyType);

    return candy == null ? 0 : candy.getQuantity();
  }

  public int sumOfCandies() {
    int sum = 0;

    for (Candy candy : candies) {
      sum += candy.getQuantity();
    }

    return sum;
  }

  public int limit() {
    return MAX_CANDIES;
  }

  public String location() {
    return city.getName();
  }
}
