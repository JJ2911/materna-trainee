package org.jeffrey.candylord;

import org.jeffrey.candylord.util.DistanceUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BRIGHT_RED = "\u001B[91m";
  public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
  public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
  public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
  public static final String ANSI_BRIGHT_MAGENTA = "\u001B[95m";
  public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
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
    LoanShark loanShark = new LoanShark();
    City city = player.getCity();
    String currentLocation = "";
    Map<City.Location, Integer> travelPrices = new HashMap<>();

    while (isValid) {
      System.out.printf("╔%s╗%n", "═".repeat(76));
      System.out.printf(
              "║%s%s%s%s%s║%n",
              " ".repeat(25),
              candyEmoji + " " + candyEmoji,
              ANSI_BRIGHT_MAGENTA + "   CANDY LORD   " + ANSI_RESET,
              candyEmoji + " " + candyEmoji,
              " ".repeat(24));
      System.out.printf("╠%s╦%s╣%n", "═".repeat(46), "═".repeat(29));
      System.out.printf(
              "║%s║%s%12s%s%s%-17s%s║%n",
              " ".repeat(46),
              ANSI_BRIGHT_CYAN,
              "Location: ",
              ANSI_RESET,
              ANSI_BRIGHT_YELLOW,
              player.location(),
              ANSI_RESET
      );
      System.out.printf(
              "╠═══%s══╦════%s════╣%s%12s%s%s%-6d(%d max)%s  ║%n",
              ANSI_BRIGHT_CYAN + " Candies on Hand " + ANSI_RESET,
              ANSI_BRIGHT_RED + " Street Prices " + ANSI_RESET,
              ANSI_BRIGHT_CYAN,
              "Hold: ",
              ANSI_RESET,
              ANSI_BRIGHT_YELLOW,
              player.sumOfCandies(),
              player.limit(),
              ANSI_RESET
      );
      System.out.printf(
              "║%s║%s║%s║%n",
              " ".repeat(22),
              " ".repeat(23),
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s%12s%s%s$%-16d%s║%n",
              mmsCandyName,
              player.getCandyQuantity(Candy.CandyType.MMS),
              mmsCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.MMS),
              ANSI_RESET,
              ANSI_BRIGHT_GREEN,
              "Cash: ",
              ANSI_RESET,
              ANSI_BRIGHT_YELLOW,
              player.getCash(),
              ANSI_RESET
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s%12s%s%s$%-16d%s║%n",
              reesesCandyName,
              player.getCandyQuantity(Candy.CandyType.REESES),
              reesesCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.REESES),
              ANSI_RESET,
              ANSI_BRIGHT_GREEN,
              "In Bank: ",
              ANSI_RESET,
              ANSI_BRIGHT_YELLOW,
              player.getBank().getBalance(),
              ANSI_RESET
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s%12s%s%s$%-16d%s║%n",
              kitKatCandyName,
              player.getCandyQuantity(Candy.CandyType.KIT_KAT),
              kitKatCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.KIT_KAT),
              ANSI_RESET,
              ANSI_BRIGHT_GREEN,
              "In Debt: ",
              ANSI_RESET,
              ANSI_BRIGHT_YELLOW,
              player.getDebt(),
              ANSI_RESET
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s║%n",
              peanutMmsCandyName,
              player.getCandyQuantity(Candy.CandyType.PEANUT_MMS),
              peanutMmsCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.PEANUT_MMS),
              ANSI_RESET,
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s%12s%s%s%-17d%s║%n",
              butterfingerCandyName,
              player.getCandyQuantity(Candy.CandyType.BUTTERFINGER),
              butterfingerCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.BUTTERFINGER),
              ANSI_RESET,
              ANSI_BRIGHT_BLUE,
              "Day: ",
              ANSI_RESET,
              ANSI_BRIGHT_YELLOW,
              player.getDay(),
              ANSI_RESET
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s║%n",
              snickersCandyName,
              player.getCandyQuantity(Candy.CandyType.SNICKERS),
              snickersCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.SNICKERS),
              ANSI_RESET,
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s║%n",
              twixCandyName,
              player.getCandyQuantity(Candy.CandyType.TWIX),
              twixCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.TWIX),
              ANSI_RESET,
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s║%n",
              milkyWayCandyName,
              player.getCandyQuantity(Candy.CandyType.MILKY_WAY),
              milkyWayCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.MILKY_WAY),
              ANSI_RESET,
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s║%n",
              hersheysCandyName,
              player.getCandyQuantity(Candy.CandyType.HERSHEYS),
              hersheysCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.HERSHEYS),
              ANSI_RESET,
              " ".repeat(29)
      );
      System.out.printf(
              "║  %-15s%3d  ║  %-14s%s%5d%s  ║%s║%n",
              marsCandyName,
              player.getCandyQuantity(Candy.CandyType.MARS),
              marsCandyName,
              ANSI_BRIGHT_RED,
              city.getCandyPrice(Candy.CandyType.MARS),
              ANSI_RESET,
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

      if (player.getDay() == 30) {
        System.out.printf(
                "You made $%d profit dealing with candies.",
                player.getCash() + player.getBank().getBalance() - player.getDebt() - 2000
        );
        break;
      }

      System.out.printf("%78s%n", "(Q)uit the game");
      System.out.println();
      System.out.printf("%29s%33s%n", "(B)uy Candies", "(V)isit the Bank");
      System.out.printf("%30s%28s%n", "(S)ell Candies", "(L)oan Shark");
      System.out.printf("%38s%15s%n", "(M)ove to another city", "S(t)ash");

      String input = scanner.nextLine();

      switch (input.trim().toLowerCase()) {
        case "b", "s" -> {
          boolean buy = input.equalsIgnoreCase("b");

          System.out.printf("%42s%n", "CANDIES");
          System.out.printf("%49s%n", "─".repeat(20));

          for (Candy.CandyType candyType : Candy.CandyType.values()) {
            System.out.printf(
                    "%s%2d. %s%n",
                    " ".repeat(31),
                    candyType.ordinal() + 1,
                    candyType.getName()
            );
          }

          System.out.printf(
                  "What candy do you want to %s? ",
                  buy ? "buy" : "sell"
          );

          if (scanner.hasNextInt()) {
            int candyNumber = scanner.nextInt();
            scanner.nextLine();

            if (candyNumber >= 1 && candyNumber <= 10) {
              System.out.printf(
                      "How many do you want to %s? ",
                      buy ? "buy" : "sell"
              );

              if (scanner.hasNextInt()) {
                Candy.CandyType candyType = Candy.CandyType.values()[candyNumber - 1];
                int candyPrice = city.getCandyPrice(candyType);
                int candyQuantity = scanner.nextInt();
                scanner.nextLine();

                if (buy) {
                  player.buy(candyType, candyQuantity, candyPrice);
                } else {
                  player.sell(candyType, candyQuantity, candyPrice);
                }

              } else {
                System.out.println("Not a number");
                scanner.nextLine();
              }

            } else {
              System.out.println("Not a candy");
            }

          } else {
            System.out.println("Not a number");
            scanner.nextLine();
          }
        }
        case "m" -> {
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
                    location.ordinal() + 1,
                    location.getName(),
                    travelPrices.get(location)
            );
          }

          System.out.println("Where do you want to go?");

          if (scanner.hasNextInt()) {
            int cityNumber = scanner.nextInt();
            scanner.nextLine();

            if (cityNumber >= 1 && cityNumber <= 8) {
              City.Location location = City.Location.values()[cityNumber - 1];
              player.travelTo(location, travelPrices.get(location));
            } else {
              System.out.println("Not a city");
            }

          } else {
            System.out.println("Not a number");
            scanner.nextLine();
          }
        }
        case "v" -> {
          System.out.printf("%46s%n", "(D)eposit money");
          System.out.printf("%47s%n", "(W)ithdraw money");

          String bankAction = scanner.nextLine();
          boolean deposit = bankAction.equalsIgnoreCase("d");
          boolean withdraw = bankAction.equalsIgnoreCase("w");

          if (deposit || withdraw) {
            System.out.printf("How much are you %s? ", deposit ? "depositing" : "withdrawing");

            if (scanner.hasNextInt()) {
              int amount = scanner.nextInt();
              scanner.nextLine();

              if (deposit) {
                player.getBank().deposit(player, amount);
              } else {
                player.getBank().withdraw(player, amount);
              }

            } else {
              System.out.println("Not a number");
              scanner.nextLine();
            }

          } else {
            System.out.println("Invalid action");
          }
        }
        case "t" -> {
          System.out.printf("%42s%n", "Stash");
          System.out.printf("%52s%n", "─".repeat(26));

          if (player.getStash().getCandies().isEmpty()) {
            System.out.printf("%42s%n", "Empty");
          } else {
            for (Candy candy : player.getStash().getCandies()) {
              System.out.printf(
                      "%s%2d. %-14s%4d%n",
                      " ".repeat(28),
                      candy.getCandyType().ordinal() + 1,
                      candy.getName(),
                      candy.getQuantity()
              );
            }
          }

          System.out.printf("%n%46s%n", "(D)eposit candy");
          System.out.printf("%47s%n", "(W)ithdraw candy");

          String stashAction = scanner.nextLine();
          boolean deposit = stashAction.equalsIgnoreCase("d");
          boolean withdraw = stashAction.equalsIgnoreCase("w");

          if (deposit || withdraw) {
            System.out.printf("Which candy are you %s? ", deposit ? "depositing" : "withdrawing");

            if (scanner.hasNextInt()) {
              int candyNumber = scanner.nextInt();
              scanner.nextLine();

              if (candyNumber >= 1 && candyNumber <= 10) {
                System.out.printf("How many are you %s? ", deposit ? "depositing" : "withdrawing");

                if (scanner.hasNextInt()) {
                  Candy.CandyType candyType = Candy.CandyType.values()[candyNumber - 1];
                  int candyQuantity = scanner.nextInt();
                  scanner.nextLine();

                  if (deposit) {
                    player.getStash().deposit(player, candyType, candyQuantity);
                  } else {
                    player.getStash().withdraw(player, candyType, candyQuantity);
                  }

                } else {
                  System.out.println("Not a number");
                  scanner.nextLine();
                }

              } else {
                System.out.println("Not a candy");
              }

            } else {
              System.out.println("Not a number");
              scanner.nextLine();
            }

          } else {
            System.out.println("Invalid action");
          }
        }
        case "l" -> {
          System.out.printf("%49s%n", "(B)orrow some cash.");
          System.out.printf("%44s%n", "(P)ay me back.");

          String loanSharkAction = scanner.nextLine();
          boolean borrow = loanSharkAction.equalsIgnoreCase("b");
          boolean pay = loanSharkAction.equalsIgnoreCase("p");

          if (borrow || pay) {
            System.out.printf("How much do you want to %s?%n", borrow ? "borrow" : "pay back");

            if (scanner.hasNextInt()) {
              int amount = scanner.nextInt();
              scanner.nextLine();

              if (borrow) {
                loanShark.getLoan(player, amount);
              } else {
                loanShark.payOffLoan(player, amount);
              }

            } else {
              System.out.println("Not a number");
              scanner.nextLine();
            }

          } else {
            System.out.println("Invalid action");
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
