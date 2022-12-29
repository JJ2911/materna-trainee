package org.jeffrey.candylord;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Market {
  private final Map<Candy.CandyType, Integer> candyPrices = new HashMap<>();

  public Market() {
    calculateCandyPrices();
  }

  public Map<Candy.CandyType, Integer> getCandyPrices() {
    return candyPrices;
  }

  public void calculateCandyPrices() {
    ThreadLocalRandom current = ThreadLocalRandom.current();
    candyPrices.put(Candy.CandyType.MMS, current.nextInt(5_000, 10_000));
    candyPrices.put(Candy.CandyType.REESES, current.nextInt(2_000, 5_000));
    candyPrices.put(Candy.CandyType.KIT_KAT, current.nextInt(1_000, 2_000));
    candyPrices.put(Candy.CandyType.PEANUT_MMS, current.nextInt(750, 1_000));
    candyPrices.put(Candy.CandyType.BUTTERFINGER, current.nextInt(500, 750));
    candyPrices.put(Candy.CandyType.SNICKERS, current.nextInt(400, 500));
    candyPrices.put(Candy.CandyType.TWIX, current.nextInt(300, 400));
    candyPrices.put(Candy.CandyType.MILKY_WAY, current.nextInt(200, 300));
    candyPrices.put(Candy.CandyType.HERSHEYS, current.nextInt(100, 200));
    candyPrices.put(Candy.CandyType.MARS, current.nextInt(10, 100));
  }
}
