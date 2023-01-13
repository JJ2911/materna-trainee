package org.jeffrey.candylord.event;

import org.jeffrey.candylord.event.Event;
import org.jeffrey.candylord.event.Luck;
import org.jeffrey.candylord.event.Mugging;
import org.jeffrey.candylord.event.Nothing;

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
