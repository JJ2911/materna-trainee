package org.jeffrey.candylord.event;

import org.jeffrey.candylord.Player;

public abstract class Event {
  public abstract void process(Player player);
}
