package runner;

import movie.Movie;
import movie.MovieCreator;

public class AllMovies {

  public static void showAllMovies() {
    for (Movie movie : MovieCreator.movies) {
      System.out
          .println("Name of movie - " + movie.getName() + ", category - " + movie.getCategory());
    }
  }
}

