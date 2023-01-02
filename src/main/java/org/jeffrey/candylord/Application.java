package org.jeffrey.candylord;

import org.jeffrey.candylord.util.DistanceUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String candyEmoji = "\uD83C\uDF6C";
    boolean isValid = true;

    final String mmsCandyName = Candy.CandyType.MMS.getName();
    final String reesesCandyName = Candy.CandyType.REESES.getName();
    final String kitKatCandyName = Candy.CandyType.KIT_KAT.getName();
    final String peanutMmsCandyName = Candy.CandyType.PEANUT_MMS.getName();
    final String butterfingerCandyName = Candy.CandyType.BUTTERFINGER.getName();
    final String snickersCandyName = Candy.CandyType.SNICKERS.getName();
    final String twixCandyName = Candy.CandyType.TWIX.getName();
    final String milkyWayCandyName = Candy.CandyType.MILKY_WAY.getName();
    final String hersheysCandyName = Candy.CandyType.HERSHEYS.getName();
    final String marsCandyName = Candy.CandyType.MARS.getName();

    Player player = new Player();
    City city = player.getCity();
    String currentLocation = "";
    Map<City.Location, Integer> travelPrices = new HashMap<>();

    while (isValid) {
      System.out.printf("╔%s╗%n", "═".repeat(76));
      System.out.printf(
              "║%s%s%s%s%s║%n",
              " ".repeat(25),
              candyEmoji + " " + candyEmoji,
              "   CANDY LORD   ",
              candyEmoji + " " + candyEmoji,
              " ".repeat(24));
      System.out.printf("╠%s╦%s╣%n", "═".repeat(46), "═".repeat(29));
      System.out.printf("║%s║%12s%-17s║%n", " ".repeat(46), "Location: ", player.location());
      System.out.printf(
              "╠═══%s══╦════%s════╣%12s%-6d(%d max)  ║%n",
              " Candies on Hand ",
              " Street Prices ",
              "Hold: ",
              player.sumOfCandies(),
              player.limit()
      );
      System.out.printf(
              "║%s║%s║%s║%n",
              " ".repeat(22),
              " ".repeat(23),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%12s$%-16d║%n",
              mmsCandyName,
              player.getCandyQuantity(Candy.CandyType.MMS),
              mmsCandyName,
              city.getCandyPrice(Candy.CandyType.MMS),
              "Cash: ",
              player.getCash()
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%12s$%-16d║%n",
              reesesCandyName,
              player.getCandyQuantity(Candy.CandyType.REESES),
              reesesCandyName,
              city.getCandyPrice(Candy.CandyType.REESES),
              "In Bank: ",
              player.getBank().getBalance()
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%12s$%-16d║%n",
              kitKatCandyName,
              player.getCandyQuantity(Candy.CandyType.KIT_KAT),
              kitKatCandyName,
              city.getCandyPrice(Candy.CandyType.KIT_KAT),
              "In Debt: ",
              player.getDebt()
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%s║%n",
              peanutMmsCandyName,
              player.getCandyQuantity(Candy.CandyType.PEANUT_MMS),
              peanutMmsCandyName,
              city.getCandyPrice(Candy.CandyType.PEANUT_MMS),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%12s%-17d║%n",
              butterfingerCandyName,
              player.getCandyQuantity(Candy.CandyType.BUTTERFINGER),
              butterfingerCandyName,
              city.getCandyPrice(Candy.CandyType.BUTTERFINGER),
              "Day: ",
              player.getDay()
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%s║%n",
              snickersCandyName,
              player.getCandyQuantity(Candy.CandyType.SNICKERS),
              snickersCandyName,
              city.getCandyPrice(Candy.CandyType.SNICKERS),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%s║%n",
              twixCandyName,
              player.getCandyQuantity(Candy.CandyType.TWIX),
              twixCandyName,
              city.getCandyPrice(Candy.CandyType.TWIX),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%s║%n",
              milkyWayCandyName,
              player.getCandyQuantity(Candy.CandyType.MILKY_WAY),
              milkyWayCandyName,
              city.getCandyPrice(Candy.CandyType.MILKY_WAY),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%s║%n",
              hersheysCandyName,
              player.getCandyQuantity(Candy.CandyType.HERSHEYS),
              hersheysCandyName,
              city.getCandyPrice(Candy.CandyType.HERSHEYS),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%5d  ║%s║%n",
              marsCandyName,
              player.getCandyQuantity(Candy.CandyType.MARS),
              marsCandyName,
              city.getCandyPrice(Candy.CandyType.MARS),
              " ".repeat(29)
      );
      System.out.printf(
              "║%s║%s║%s║%n",
              " ".repeat(22),
              " ".repeat(23),
              " ".repeat(29)
      );
      System.out.printf(
              "╚%s╩%s╩%s╝%n",
              "═".repeat(22),
              "═".repeat(23),
              "═".repeat(29)
      );
      System.out.printf("%78s%n", "(Q)uit the game");
      System.out.println();
      System.out.printf("%29s%33s%n", "(B)uy Candies", "(V)isit the Bank");
      System.out.printf("%30s%28s%n", "(S)ell Candies", "(L)oan Shark");
      System.out.printf("%38s%n", "(M)ove to another city");

      String input = scanner.next();

      switch (input.trim().toLowerCase()) {
        case "b", "s" -> {
          boolean buy = input.equalsIgnoreCase("b");
          int index = 1;

          System.out.printf("%43s%n", "CANDIES");
          System.out.printf("%49s%n", "─".repeat(19));

          for (Candy.CandyType candyType : Candy.CandyType.values()) {
            System.out.printf("%s%d. %s%n", " ".repeat(32), index, candyType.getName());
            index++;
          }

          System.out.printf(
                  "What candy do you want to %s? ",
                  buy ? "buy" : "sell"
          );

          int candyNumber = scanner.nextInt();

          if (candyNumber >= 1 && candyNumber <= 10) {
            System.out.printf(
                    "How many do you want to %s? ",
                    buy ? "buy" : "sell"
            );

            Candy.CandyType candyType = Candy.CandyType.values()[candyNumber - 1];
            int candyQuantity = scanner.nextInt();
            int candyPrice = city.getCandyPrice(candyType);

            if (buy) {
              player.buy(candyType, candyQuantity, candyPrice);
            } else {
              player.sell(candyType, candyQuantity, candyPrice);
            }
          } else {
            System.out.println("Not a candy");
          }
        }
        case "m" -> {
          int index = 1;

          if (!currentLocation.equalsIgnoreCase(player.location())) {
            for (City.Location location : City.Location.values()) {
              travelPrices.put(
                      location,
                      DistanceUtils.calculateTravelPrice(
                              DistanceUtils.distanceTo(city.getLocation(), location)
                      )
              );
            }

            currentLocation = player.location();
          }

          System.out.printf("%42s%n", "Cities");
          System.out.printf("%53s%n", "─".repeat(28));

          for (City.Location location : City.Location.values()) {
            System.out.printf(
                    "%s%d. %-18s%3d%n",
                    " ".repeat(27),
                    index,
                    location.getName(),
                    travelPrices.get(location)
            );
            index++;
          }

          System.out.println("Where do you want to go?");
          int cityNumber = scanner.nextInt();

          if (cityNumber >= 1 && cityNumber <= 8) {
            City.Location location = City.Location.values()[cityNumber - 1];
            player.travelTo(location, travelPrices.get(location));
          } else {
            System.out.println("Not a city");
          }
        }
        case "q" -> {
          isValid = false;
        }
        default -> System.out.println("Invalid action");
      }
    }
  }
}
