package org.jeffrey.candylord;

public class City {
  public enum Location {
    CHICAGO("Chicago", 41.8781, 87.6298),
    DETROIT("Detroit", 42.3314, 83.0458),
    LAS_VEGAS("Las Vegas", 36.1716, 115.1391),
    LOS_ANGELES("Los Angeles", 34.0522, 118.2437),
    MIAMI("Miami", 25.7617, 80.1918),
    BRONX("Bronx", 40.8448, 73.8648),
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
  }

  private Market market = new Market();

  private Location location;

  private String name;

  public City(Location location) {
    setLocation(location);
    setName(location);
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
    setName(location);
    market.calculateCandyPrices();
  }

  public String getName() {
    return name;
  }

  private void setName(Location location) {
    this.name = location.getName();
  }

  public int getCandyPrice(Candy.CandyType candyType) {
    return market.getCandyPrices().get(candyType);
  }
}
