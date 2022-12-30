package org.jeffrey.candylord;

public class RandomGameEvents {
  private RandomGameEvents() {
  }

  public static Event next() {
    double random = Math.random();

    if (random < 0.6) {
      return new Nothing();
    }

    if (random < 0.9) {
      return new Luck();
    }

    return new Mugging();
  }
}
