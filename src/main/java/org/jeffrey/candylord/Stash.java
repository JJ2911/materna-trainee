package org.jeffrey.candylord;

import java.util.ArrayList;
import java.util.List;

public class Stash {
  private final List<Candy> candies = new ArrayList<>();

  public Stash() {
  }

  public List<Candy> getCandies() {
    return candies;
  }

  public void deposit(Player player, Candy.CandyType candyType, int quantity) {
    if (!City.Location.isInBronx(player)) {
      System.out.println("Your stash is located in the Bronx.");
      return;
    }

    if (quantity < 1) {
      System.out.println("The quantity needs to be greater than 0.");
      return;
    }

    Candy playerCandy = player.getCandy(candyType);

    if (playerCandy != null) {
      if (quantity <= playerCandy.getQuantity()) {
        playerCandy.setQuantity(playerCandy.getQuantity() - quantity);

        Candy candy = getCandyFromStash(candyType);

        if (candy != null) {
          candy.setQuantity(candy.getQuantity() + quantity);
        } else {
          candies.add(new Candy(candyType, quantity));
        }

        System.out.printf("Your deposit of %d %s was successful.%n", quantity, candyType.getName());

        if (playerCandy.getQuantity() == 0) {
          player.getCandies().remove(playerCandy);
        }
      } else {
        System.out.printf("You don't have %d %s on hand.%n", quantity, candyType.getName());
      }
    } else {
      System.out.printf("You don't have %s on hand.%n", candyType.getName());
    }
  }

  public void withdraw(Player player, Candy.CandyType candyType, int quantity) {
    if (!City.Location.isInBronx(player)) {
      System.out.println("Your stash is located in the Bronx.");
      return;
    }

    if (quantity < 1) {
      System.out.println("The quantity needs to be greater than 0.");
      return;
    }

    Candy candy = getCandyFromStash(candyType);

    if (candy != null) {
      if (quantity <= candy.getQuantity()) {
        candy.setQuantity(candy.getQuantity() - quantity);

        Candy playerCandy = player.getCandy(candyType);

        if (playerCandy != null) {
          playerCandy.setQuantity(playerCandy.getQuantity() + quantity);
        } else {
          player.getCandies().add(new Candy(candyType, quantity));
        }

        if (candy.getQuantity() == 0) {
          candies.remove(candy);
        }

        System.out.printf("Your withdrawal of %d %s was successful.%n", quantity, candyType.getName());
      } else {
        System.out.printf("You don't have %d %s in your stash.%n", quantity, candyType.getName());
      }
    } else {
      System.out.printf("You don't have %s in your stash.%n", candyType.getName());
    }
  }

  public Candy getCandyFromStash(Candy.CandyType candyType) {
    for (Candy candy : candies) {
      if (candy.getCandyType() == candyType) {
        return candy;
      }
    }

    return null;
  }
}
