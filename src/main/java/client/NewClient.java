package client;

import booking.Transaction;
import java.util.Scanner;

public class NewClient {

  Scanner sc = new Scanner(System.in);
  Transaction transaction = new Transaction();
  String phoneNumb;

  public void registrationNewClient(String phoneNumb) {
    this.phoneNumb = phoneNumb;
    System.out.println("Please enter your details in format name, surname, age, email");
    String input = sc.nextLine();
    String[] scannerLine = input.split("\\s*,\\s*");
    try {
      RegisteredClient.registeredClient = new Client(scannerLine[0], scannerLine[1],
          Integer.parseInt(scannerLine[2]), scannerLine[3], phoneNumb);
      ClientsData.clients.add(RegisteredClient.registeredClient);
      transaction.inputMovie();
    } catch (NumberFormatException e) {
      System.out.println("Incorrect input, try again");
      registrationNewClient(phoneNumb);
    }
  }
}
