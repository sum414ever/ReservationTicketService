package runner;

import cinema.Cinema;
import cinema.CinemaCreator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import movie.Movie;

public class CinemaInformationByName {

  public static void getInformation() {

    System.out.println("Please write tne name of cinema:");
    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    List<Cinema> info = CinemaCreator.cinemas.stream()
        .filter(cinema -> cinema.getName().equals(name))
        .collect(Collectors.toList());
    List<Movie> thisCinemaMovies = info.get(0).getMovies();
    for (Movie movie : thisCinemaMovies) {
      System.out.println(
          "Movie name: '" + movie.getName() + "', number of room - " + movie
              .getNumberOfRoom()
              + ", type of movie - " + movie.getTypeOfMovie() + ", status of movie - " + movie
              .getStatusOfMovie() + ", duration from/to - " + movie.getDurationFrom() + "/"
              + movie.getDurationTo() + ", normal price  - " + movie.getPriceNormal()
              + ", premium price  - " + movie.getPricePremium() + ", VIP price  - " + movie
              .getPriceVip() + ", category - "
              + movie.getCategory());
    }
  }
}