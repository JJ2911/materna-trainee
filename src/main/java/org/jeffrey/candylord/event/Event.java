package org.jeffrey.candylord.event;

import org.jeffrey.candylord.Player;

/**
 * @author Jeffrey Liew
 */
public abstract class Event {
  /**
   * This method is called during a player's travel to another city.
   *
   * @param player the player
   */
  public abstract void process(Player player);
}
