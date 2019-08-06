package booking;

import client.AreYouStudent;
import client.RegisteredClient;
import hall.Hall;
import hall.Place;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import movie.Movie;
import movie.MovieCreator;
import movie.StatusOfMovie;
import movie.TypeOfPlaces;
import runner.AppRunner;

public class Transaction {

    private Movie movie;
    private Hall hall;
    private LocalDate bookingDate;
    private String row;
    private String place;
    private boolean paymentStatus;
    private TypeOfPlaces typeOfPlace;
    private Booking thisBooking;
    private Scanner sc = new Scanner(System.in);
    private List<Booking> unpaidTicket;
    private List<Booking> bookings;
    private String[] tickets;
    private BigDecimal discount7 = new BigDecimal(0.93);
    private BigDecimal discount10 = new BigDecimal(0.90);
    private BigDecimal discount15 = new BigDecimal(0.85);
    private BigDecimal cost = new BigDecimal(0);
    private int age;
    private final int MAX_STUDENT_AGE = 21;
    private final int MIN_STUDENT_AGE = 16;
    private AreYouStudent areYouStudent = age -> age > MIN_STUDENT_AGE && age < MAX_STUDENT_AGE;

    public void inputMovie() {
        age = RegisteredClient.registeredClient.getAge();
        System.out.println("Please enter movie name");
        String name = sc.nextLine();
        List<Movie> info = MovieCreator.movies.stream().filter(movie -> movie.getName().equals(name))
                .collect(Collectors.toList());
        movie = info.get(0);
        inputDate();
    }

    private void inputDate() {
        System.out.println("Please enter date when you want to see movie 'yyyy-mm-dd");
        System.out.println(
                "This movie is shown with " + movie.getDurationFrom() + " to " + movie.getDurationTo());
        String date = sc.next();
        bookingDate = LocalDate.parse(date);
        List<Hall> thisDateHall = movie.getHalls().stream()
                .filter(hall -> hall.getDate().equals(bookingDate))
                .collect(Collectors.toList());
        hall = thisDateHall.get(0);
        showFreePlaces();
    }

    private void showFreePlaces() {
        System.out.println(
                "Please enter type of place: \n Enter 1 if you want normal type of place,\n Enter 2 if you want premium type of place \n Enter 3 if you want vip type of place ");

        int typePlace = sc.nextInt();
        switch (typePlace) {

            case 1:
                System.out.println("These are all free places in normal type");
                typeOfPlace = TypeOfPlaces.NORMAL;
                showFreePlaces(typeOfPlace);
                choosePlaces();
                break;

            case 2:
                System.out.println("These are  all free places in premium type");
                typeOfPlace = TypeOfPlaces.PREMIUM;
                showFreePlaces(typeOfPlace);
                choosePlaces();
                break;

            case 3:
                System.out.println("These are all free places in vip type");
                typeOfPlace = TypeOfPlaces.VIP;
                showFreePlaces(typeOfPlace);
                choosePlaces();
                break;
        }
    }

    public void showFreePlaces(TypeOfPlaces typeOfPlace) {
        List<Place> places = hall.getPlaces();
        List<Place> freePlace;
        cost = movie.getPriceVip();
        freePlace = places.stream().filter(place -> place.getTypeOfPlaces() == TypeOfPlaces.VIP)
                .collect(
                        Collectors.toList());
        int rowNumb2 = 0;
        String rows2 = "";
        for (Place place : freePlace) {
            if (!place.isBusy()) {
                if (rowNumb2 != place.getRowNumber()) {
                    rows2 = rows2 + "\n";
                    rows2 = rows2 + "Row - " + place.getRowNumber() + ", place number - " + place
                            .getPlaceNumber();
                    rowNumb2 = place.getRowNumber();
                } else {
                    rows2 = rows2 + ", " + place.getPlaceNumber();
                }
            }
        }
        System.out.println(rows2);
    }

    private void choosePlaces() {
        System.out.println("Please choose the row and the place. Example 'row,place'");
        String chose = sc.nextLine();
        chose = sc.nextLine();
        String[] scannerLine = chose.split("\\s*,\\s*");
        try {
            row = scannerLine[0];
            place = scannerLine[1];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect input, try again");
            choosePlaces();
        }
        selectTypeOfReservation();
    }

    private void selectTypeOfReservation() {
        System.out.println(
                "Do you want to pay or just booking it? \nEnter 1 if you want pay.\nEnter 2 if you want to booking it.");
        unpaidTicket = RegisteredClient.registeredClient.getBookings();
        thisBooking = new Booking(bookingDate, paymentStatus, movie, row, place, cost);
        unpaidTicket.add(thisBooking);
        int typeOfPayment = sc.nextInt();

        switch (typeOfPayment) {

            case 1:
                showUnpaidTicket();
                break;

            case 2:
                int count = 0;
                for (Booking b : unpaidTicket) {
                    if (!b.getPaymentStatus()) {
                        count++;
                    }
                }
                if (count > 2) {
                    System.out.println("Sorry, but you have more 2 unpaid bookings, you should pay one");
                    System.out.println(
                            "If you want to pay, please, enter 1 \n Enter 2, if you want to come back to main menu");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            showUnpaidTicket();
                            break;
                        case 2:
                            AppRunner.startApp();
                            break;
                    }
                } else {
                    System.out.println("Done. You added your ticket in booking");
                    AppRunner.startApp();
                }
                typeOfPayment = sc.nextInt();
                break;
        }
    }

    private void showUnpaidTicket() {
        System.out.println("You have this unpaid tickets:");
        int count = 1;
        for (Booking b : unpaidTicket) {
            if (!b.getPaymentStatus()) {
                System.out.println(
                        count + ". Movie - " + b.getBookedMovie().getName() + ", date - " + b.getBookedDate()
                                + ", row -" + b.getRow() + ", place -" + b.getPlace());
                count++;
            }
        }
        chooseTicket();
    }

    private void chooseTicket() {
        System.out.println("Please, enter the numbers of tickets '1,2...n', what do you want to pay ");
        String numbTicket = sc.nextLine();
        numbTicket = sc.nextLine();
        tickets = numbTicket.split("\\s*,\\s*");
        valuation();
    }

    private void valuation() {
        int numbThicket;
        for (int i = 0; i < tickets.length - 1; i++) {
            numbThicket = Integer.parseInt(tickets[i]);
            StatusOfMovie statusOfMovie = unpaidTicket.get(numbThicket).getBookedMovie()
                    .getStatusOfMovie();
            if (areYouStudent.isStudent(age) && statusOfMovie == StatusOfMovie.PRE_PREMIERE) {
                cost = cost.add(unpaidTicket.get(numbThicket).getPrice()).multiply(discount7);
            } else if (areYouStudent.isStudent(age) && statusOfMovie == StatusOfMovie.PREMIERE) {
                cost = cost.add(unpaidTicket.get(numbThicket).getPrice()).multiply(discount10);
            } else {
                cost = cost.add(unpaidTicket.get(numbThicket).getPrice()).multiply(discount15);
            }
        }
        System.out
                .println("For you this ticket cost - " + cost.setScale(2, BigDecimal.ROUND_HALF_UP));
        payment();
    }

    private void payment() {
        System.out.println("Enter your sum ");
        String input = sc.nextLine();
        BigDecimal sum = new BigDecimal(input);

        if (sum.compareTo(cost) == -1) {
            System.out.println("You enter a small sum, please try again");
            payment();
        } else if (sum.compareTo(cost) == 0) {
            System.out.println(" Ok, well done, you bought the ticket");
            changePaymentStatus();
            AppRunner.startApp();
        } else {
            System.out.println("Ok, well done, you bought the ticket, and here is your change " + sum
                    .subtract(cost.setScale(2, BigDecimal.ROUND_HALF_UP)));
            changePaymentStatus();
            AppRunner.startApp();
        }
        AppRunner.startApp();
    }

    public void changePaymentStatus() {
        int numbThicket;
        for (int i = 0; i < tickets.length; i++) {
            numbThicket = Integer.parseInt(tickets[i]) - 1;
            bookings = RegisteredClient.registeredClient.getBookings();
            for (Booking b : bookings) {
                if (b.getBookedMovie().getName() == unpaidTicket.get(numbThicket).getBookedMovie()
                        .getName() && b.getBookedDate() == unpaidTicket.get(numbThicket).getBookedDate()
                        && b.getRow() == unpaidTicket.get(numbThicket).getRow()
                        && b.getPlace() == unpaidTicket
                        .get(numbThicket).getPlace()) {
                    unpaidTicket.get(numbThicket).setPaymentStatus(true);
                }
            }
//      input = sc.nextLine();
        }
    }
}
