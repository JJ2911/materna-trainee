package org.jeffrey.candylord;

public class Candy {
  public enum CandyType {
    MMS("M&Ms"),
    REESES("Reese's"),
    KIT_KAT("Kit Kat"),
    PEANUT_MMS("Peanut M&Ms"),
    BUTTERFINGER("Butterfinger"),
    SNICKERS("Snickers"),
    TWIX("Twix"),
    MILKY_WAY("Milky Way"),
    HERSHEYS("Hershey's"),
    MARS("Mars");

    private final String name;

    CandyType(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  private CandyType candyType;
  private String name;
  private int quantity;

  public Candy(CandyType candyType, int quantity) {
    setCandyType(candyType);
    setName(candyType);
    setQuantity(quantity);
  }

  public CandyType getCandyType() {
    return candyType;
  }

  public void setCandyType(CandyType candyType) {
    this.candyType = candyType;
  }

  public String getName() {
    return name;
  }

  private void setName(CandyType candyType) {
    this.name = candyType.getName();
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
