package movie;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MovieCreator {

  public static List<Movie> movies = new ArrayList<Movie>();

  static {
    try {
      createMovies();
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public static void createMovies() throws ParseException {
    movies.add(
        new Movie("The Farewell", 1, TypeOfMovie.ORIGINAL, StatusOfMovie.PRE_PREMIERE, "2019-01-20",
            "2019-06-26", 150, 200, 250, Category.Fantasy));
    movies.add(new Movie("Avengers: Endgame", 2, TypeOfMovie.TRANSLATED, StatusOfMovie.AVAILABLE,
        "2019-03-30", "2019-09-20", 250, 300, 350, Category.Action));
    movies.add(new Movie("Wild rose", 3, TypeOfMovie.ORIGINAL, StatusOfMovie.PREMIERE, "2019-02-12",
        "2020-07-20", 300, 350, 400, Category.Drama));
    movies.add(
        new Movie("Echo In the Canyon", 4, TypeOfMovie.TRANSLATED, StatusOfMovie.PRE_PREMIERE,
            "2019-04-25", "2019-11-21", 350, 400, 450, Category.Horror));
    movies.add(
        new Movie("Fighting with My Family", 5, TypeOfMovie.ORIGINAL, StatusOfMovie.AVAILABLE,
            "2019-03-01", "2019-10-20", 100, 150, 200, Category.Fantasy));
    movies.add(new Movie("Giant little ones", 6, TypeOfMovie.ORIGINAL, StatusOfMovie.PRE_PREMIERE,
        "2019-05-01", "2019-12-31", 250, 300, 350, Category.Action));
    movies.add(new Movie("High flying bird", 7, TypeOfMovie.TRANSLATED, StatusOfMovie.PREMIERE,
        "2019-01-01", "2019-09-01", 300, 350, 400, Category.Drama));
    movies.add(new Movie("Shazam", 8, TypeOfMovie.ORIGINAL, StatusOfMovie.AVAILABLE, "2019-01-31",
        "2019-12-31", 350, 400, 450, Category.Fantasy));
    movies.add(
        new Movie("Gloria Bell ", 9, TypeOfMovie.ORIGINAL, StatusOfMovie.PRE_PREMIERE, "2019-07-20",
            "2020-01-20", 400, 450, 500, Category.Fantasy));
    movies.add(
        new Movie("Sauvage / Wild", 10, TypeOfMovie.TRANSLATED, StatusOfMovie.PREMIERE,
            "2019-02-21",
            "2019-09-20", 150, 200, 250, Category.Drama));
  }
}
