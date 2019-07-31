package movie;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import runner.AppRunner;

public class MoviesByFactors {

  private static final int CATEGORY = 1;
  private static final int STATUS = 2;
  private static final int TYPE = 3;
  private static final int BACK = 4;
  private static final int EXIT = 5;
  private static Scanner scan = new Scanner(System.in);
  private static int input;

  public static void sortByFactor() {

    input = scan.nextInt();

    while (input != EXIT) {
      switch (input) {
        case CATEGORY:
          List<String> drama = MovieCreator.movies.stream()
              .filter(movie -> movie.getCategory()
                  .equals(Category.Drama)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in category of Drama " + drama);

          List<String> fantasy = MovieCreator.movies.stream()
              .filter(movie -> movie.getCategory()
                  .equals(Category.Fantasy)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in category of Fantasy " + fantasy);

          List<String> action = MovieCreator.movies.stream()
              .filter(movie -> movie.getCategory()
                  .equals(Category.Action)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in category of Action " + action);

          List<String> horror = MovieCreator.movies.stream()
              .filter(movie -> movie.getCategory()
                  .equals(Category.Horror)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in category of Horror " + horror);
          input = scan.nextInt();
          break;

        case STATUS:
          List<String> available = MovieCreator.movies.stream()
              .filter(movie -> movie.getStatusOfMovie()
                  .equals(StatusOfMovie.AVAILABLE)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in status of Available " + available);

          List<String> premiere = MovieCreator.movies.stream()
              .filter(movie -> movie.getStatusOfMovie()
                  .equals(StatusOfMovie.PREMIERE)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in status of Premiere " + premiere);

          List<String> prePremier = MovieCreator.movies.stream()
              .filter(movie -> movie.getStatusOfMovie()
                  .equals(StatusOfMovie.PRE_PREMIERE)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in status of Pre-premiere " + prePremier);
          input = scan.nextInt();
          break;

        case TYPE:
          List<String> original = MovieCreator.movies.stream()
              .filter(movie -> movie.getTypeOfMovie()
                  .equals(TypeOfMovie.ORIGINAL)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in type of Original " + original);

          List<String> translated = MovieCreator.movies.stream()
              .filter(movie -> movie.getTypeOfMovie()
                  .equals(TypeOfMovie.TRANSLATED)).map(Movie::getName)
              .collect(Collectors.toList());
          System.out.println("These are all movies in type of Translated " + translated);
          input = scan.nextInt();
          break;
        case BACK:
          AppRunner.run();
      }
    }
  }
}
