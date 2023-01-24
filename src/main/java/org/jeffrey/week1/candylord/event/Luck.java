package org.jeffrey.week1.candylord.event;

import org.jeffrey.week1.candylord.Candy;
import org.jeffrey.week1.candylord.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jeffrey Liew
 */
public class Luck extends Event {
  private final int MAX_FOUND_CANDIES = 10;

  /**
   * Adds a random candy to the player.
   *
   * @param player the player
   */
  @Override
  public void process(Player player) {
    ThreadLocalRandom current = ThreadLocalRandom.current();
    double number = current.nextDouble(1);
    Candy.CandyType candyType = null;

    if (number < 0.25) {
      candyType = Candy.CandyType.MARS;
    } else if (number < 0.35) {
      candyType = Candy.CandyType.HERSHEYS;
    } else if (number < 0.45) {
      candyType = Candy.CandyType.MILKY_WAY;
    } else if (number < 0.55) {
      candyType = Candy.CandyType.TWIX;
    } else if (number < 0.65) {
      candyType = Candy.CandyType.SNICKERS;
    } else if (number < 0.775) {
      candyType = Candy.CandyType.BUTTERFINGER;
    } else if (number < 0.9) {
      candyType = Candy.CandyType.PEANUT_MMS;
    } else if (number < 0.95) {
      candyType = Candy.CandyType.KIT_KAT;
    } else if (number < 0.98) {
      candyType = Candy.CandyType.REESES;
    } else if (number < 1) {
      candyType = Candy.CandyType.MMS;
    }

    int quantity = current.nextInt(1, MAX_FOUND_CANDIES + 1);

    if (player.sumOfCandies() + quantity < player.getMAX_CANDIES() + MAX_FOUND_CANDIES) {
      if (!(player.sumOfCandies() + quantity <= player.getMAX_CANDIES())) {
        quantity = quantity - (player.sumOfCandies() + quantity - player.getMAX_CANDIES());
      }

      for (Candy candy : player.getCandies()) {
        if (candy.getCandyType() == candyType) {
          candy.setQuantity(candy.getQuantity() + quantity);
          System.out.printf("You have found %d %s.%n", quantity, candyType.getName());
          return;
        }
      }

      player.getCandies().add(new Candy(candyType, quantity));
      System.out.printf("You have found %d %s.%n", quantity, candyType.getName());
    }
  }
}
