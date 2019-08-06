package runner;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import movie.Movie;
import movie.MovieCreator;

public class MovieInfo {

  public static void getInformation() {

    System.out.println("Please write tne name of movie:");
    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    List<Movie> info = MovieCreator.movies.stream().filter(movie -> movie.getName().equals(name))
        .collect(Collectors.toList());
    System.out.println(
        "Movie name: '" + info.get(0).getName() + "', number of room - " + info.get(0)
            .getNumberOfRoom()
            + ", type of movie - " + info.get(0).getTypeOfMovie() + ", status of movie - " + info
            .get(0)
            .getStatusOfMovie() + ", duration from/to - " + info.get(0).getDurationFrom() + "/"
            + info
            .get(0).getDurationTo() + ", normal price  - " + info.get(0).getPriceNormal()
            + ", premium price  - " + info.get(0).getPricePremium() + ", VIP price  - " + info
            .get(0).getPriceVip() + ", category - "
            + info.get(0).getCategory());
  }
}
