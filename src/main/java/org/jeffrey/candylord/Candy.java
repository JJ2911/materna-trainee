package org.jeffrey.candylord;

/**
 * @author Jeffrey Liew
 */
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

  /**
   * Constructs a new <code>Candy</code> that initializes the candy type, candy name and candy quantity.
   *
   * @param candyType Type of candy
   * @param quantity Candy quantity
   */
  public Candy(CandyType candyType, int quantity) {
    setCandyType(candyType);
    setName(candyType);
    setQuantity(quantity);
  }

  /**
   * Returns the candy type.
   *
   * @return the candy type
   */
  public CandyType getCandyType() {
    return candyType;
  }

  /**
   * Sets the candy type.
   *
   * @param candyType Type of candy
   */
  public void setCandyType(CandyType candyType) {
    this.candyType = candyType;
  }

  /**
   * Returns the candy name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the candy name.
   *
   * @param candyType Type of candy
   */
  private void setName(CandyType candyType) {
    this.name = candyType.getName();
  }

  /**
   * Returns the candy quantity.
   *
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the candy quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
