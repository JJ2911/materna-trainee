package org.jeffrey.candylord;

/**
 * The city class for setting the player's city.
 *
 * @author Jeffrey Liew
 */
public class City {
  public enum Location {
    CHICAGO("Chicago", 41.8781, 87.6298),
    DETROIT("Detroit", 42.3314, 83.0458),
    LAS_VEGAS("Las Vegas", 36.1716, 115.1391),
    LOS_ANGELES("Los Angeles", 34.0522, 118.2437),
    MIAMI("Miami", 25.7617, 80.1918),
    BRONX("The Bronx", 40.8448, 73.8648),
    SAN_DIEGO("San Diego", 32.7157, 117.1611),
    WASHINGTON_DC("Washington D.C.", 38.9072, 77.0369);

    private final String name;
    private final double lat;
    private final double lon;

    Location(String name, double lat, double lon) {
      this.name = name;
      this.lat = lat;
      this.lon = lon;
    }

    public String getName() {
      return name;
    }

    public double getLat() {
      return lat;
    }

    public double getLon() {
      return lon;
    }

    public static boolean isInBronx(Player player) {
      return player.getCity().getLocation() == BRONX;
    }
  }

  private Market market = new Market();
  private Location location;
  private String name;

  /**
   * Constructs a new <code>City</code> that initializes the location.
   *
   * @param location the location
   */
  public City(Location location) {
    setLocation(location);
    setName(location);
  }

  /**
   * Returns the location.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Sets the location, name and calculates new candy prices.
   *
   * @param location the new location
   */
  public void setLocation(Location location) {
    this.location = location;
    setName(location);
    market.calculateCandyPrices();
  }

  /**
   * Gets the city name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name for the new location.
   *
   * @param location the new location
   */
  private void setName(Location location) {
    this.name = location.getName();
  }

  /**
   * Returns the price of a specific candy.
   *
   * @param candyType Type of candy
   * @return the candy price
   */
  public int getCandyPrice(Candy.CandyType candyType) {
    return market.getCandyPrices().get(candyType);
  }
}
