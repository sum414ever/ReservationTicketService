package runner;

import cinema.Cinema;

import cinema.CinemaCreator;

public class AllCinemas {

  public static void showAllCinemas() {
    for (Cinema cinema : CinemaCreator.cinemas) {
      System.out
          .println("Name of cinema - " + cinema.getName() + ", address - " + cinema.getAddress());
    }
  }
}
