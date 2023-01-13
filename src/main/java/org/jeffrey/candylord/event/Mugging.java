package org.jeffrey.candylord.event;

import org.jeffrey.candylord.Player;

/**
 * @author Jeffrey Liew
 */
public class Mugging extends Event {
  /**
   * Sets the player's cash to <code>0</code>.
   *
   * @param player the player
   */
  @Override
  public void process(Player player) {
    player.setCash(0);
    System.out.println("Someone steals all your money.");
  }
}
