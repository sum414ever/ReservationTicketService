package cinema;

import java.util.ArrayList;
import java.util.List;
import movie.Movie;
import movie.MovieCreator;

public class CinemaCreator {

  public static List<Cinema> cinemas = new ArrayList<>();
  public static List<Movie> firstListMovie = new ArrayList<>();
  public static List<Movie> secondListMovie = new ArrayList<>();
  public static List<Movie> thirdListMovie = new ArrayList<>();

  static {
    //divide movies list to cinemas
    for (int i = 0; i < MovieCreator.movies.size(); i++) {
      if (MovieCreator.movies.get(i).getNumberOfRoom() % 3 == 0) {
        thirdListMovie.add(MovieCreator.movies.get(i));
      } else if (MovieCreator.movies.get(i).getNumberOfRoom() % 2 == 0) {
        secondListMovie.add(MovieCreator.movies.get(i));
      } else {
        firstListMovie.add(MovieCreator.movies.get(i));
      }
    }
    // create 3 cinemas
    cinemas.add(new Cinema("First", "Garden Street,10", "9/10", firstListMovie));
    cinemas.add(new Cinema("Second", "7-th Avenue", "8/10", secondListMovie));
    cinemas.add(new Cinema("Third", "Marshals prospect.5", "10/10", thirdListMovie));
  }
}
