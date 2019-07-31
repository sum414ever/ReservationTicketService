package client;

import booking.Booking;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import runner.AppRunner;

public class AllInformationGenerator {

  private Scanner scan = new Scanner(System.in);
  private String thisInput = scan.nextLine();
  private List<Client> thisClient;
  private String paymentStatus = "";

  public void showAllInformation() {
    thisClient = ClientsData.clients.stream()
        .filter(client -> client.getPhoneNumber().equals(thisInput)).collect(Collectors.toList());
    if (!thisClient.isEmpty()) {
      System.out.println("There are all your booking: ");
      for (Booking b : thisClient.get(0).getBookings()) {
        if(b.getPaymentStatus()){
          paymentStatus = "paid";
        }else {
          paymentStatus = "unpaid";
        }
        System.out.println(
            "Movie name - " + b.getBookedMovie().getName() + ", date - " + b.getBookedDate()
                + ", row and place - " + b.getRow() + ", " + b.getPlace() + ", and price - " + b
                .getPrice() + ", payment status - " + paymentStatus);
      }
    } else {
      System.out.println("Client not found");
    }
    AppRunner.run();
  }
}