package org.jeffrey.candylord.util;

import org.jeffrey.candylord.City;

/**
 * @author Jeffrey Liew
 */
public class DistanceUtils {
  private static final double pricePerKm = 0.10;

  /**
   * Returns the distance in km between two locations.
   *
   * @param location1 the first location
   * @param location2 the second location
   * @return the distance in km
   */
  public static double distanceTo(City.Location location1, City.Location location2) {
    double lat1 = location1.getLat();
    double lon1 = location1.getLon();
    double lat2 = location2.getLat();
    double lon2 = location2.getLon();

    if (lat1 == lat2 && lon1 == lon2) {
      return 0;
    }

    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);

    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);

    return 2 * 6371 * Math.asin(Math.sqrt(a));
  }

  /**
   * Returns the travel price based on distance.
   *
   * @param distance the distance in km
   * @return the price
   */
  public static int calculateTravelPrice(double distance) {
    return (int) Math.round(distance * pricePerKm);
  }
}
