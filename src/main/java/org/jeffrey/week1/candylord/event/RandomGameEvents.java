package org.jeffrey.week1.candylord.event;

/**
 * @author Jeffrey Liew
 */
public class RandomGameEvents {
  private RandomGameEvents() {
  }

  /**
   * Returns a random event.
   *
   * @return the event
   */
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
