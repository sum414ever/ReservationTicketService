package runner;

import client.AllInformationGenerator;
import client.ClientLogin;
import java.util.Scanner;
import movie.MoviesSorter;

public class AppRunner {

  static final int ALL_CINEMAS = 1;
  static final int MORE_INFORMATION = 2;
  static final int ALL_MOVIES = 3;
  static final int MOVIES_BY_NAME = 4;
  static final int MOVIES_BY_FACTORS = 5;
  static final int BUY_TICKETS = 6;
  static final int SEE_ALL_INFORMATION = 7;
  static final int EXIT = 8;

  public static void startApp() {

    System.out.println("Please choose what do you want to do ");
    System.out.println("Write 1, if you want to see a list of all cinemas   ");
    System.out.println("Write 2, if you want to see a list of movies in some cinema   ");
    System.out.println("Write 3, if you want to see a list of all movies ");
    System.out.println("Write 4, if you want to see a more information about movie by name ");
    System.out.println("Write 5, if you want to see all the movies by various factors");
    System.out.println("Write 6, if you want to buy or add in booking the ticket");
    System.out.println("Write 7, if you want to see the information  about all your bookings");
    System.out.println("Write 8, if you want exit");

    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();

    while (input != EXIT) {
      if (input > 0 && input < 8) {
      switch (input) {
          case ALL_CINEMAS:
            System.out.println("These are all our cinemas: ");
            AllCinemasList.showAllCinemas();
            break;

          case MORE_INFORMATION:
            ListOfCinemas.getInformation();
            break;

          case ALL_MOVIES:
            Poster.showAllMovies();
            break;

          case MOVIES_BY_NAME:
            MovieInfo.getInformation();
            break;

          case MOVIES_BY_FACTORS:
            System.out.println("Write 1, if you want to sort all the movies by category  ");
            System.out.println("Write 2, if you want to sort all the movies by status of movie  ");
            System.out.println("Write 3, if you want to sort all the movies by type of movie  ");
            System.out.println("Write 4, if you want to back to main menu  ");

            MoviesSorter.sortByFactor();
            break;

          case BUY_TICKETS:
            System.out.println("Please write your phone number");
            ClientLogin clientLogin = new ClientLogin();
            clientLogin.checkClient();
            break;
          case SEE_ALL_INFORMATION:
            System.out.println("Please write your phone number");
            AllInformationGenerator allInformationGenerator = new AllInformationGenerator();
            allInformationGenerator.showAllInformation();
            break;
        }
      }
      input = scan.nextInt();
    }
  }
}


