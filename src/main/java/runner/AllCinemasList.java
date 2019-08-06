package runner;

import cinema.Cinema;

import cinema.CinemaCreator;

public class AllCinemasList {

  public static void showAllCinemas() {
    for (Cinema cinema : CinemaCreator.cinemas) {
      System.out
          .println("Name of cinema - " + cinema.getName() + ", address - " + cinema.getAddress());
    }
  }
}
