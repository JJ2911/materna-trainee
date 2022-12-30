package org.jeffrey.candylord;

public class Mugging extends Event {
  @Override
  public void process(Player player) {
    player.setCash(0);
    System.out.println("Someone steals all your money.");
  }
}
