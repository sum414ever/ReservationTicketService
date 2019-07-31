package client;

import booking.Transaction;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClientLogin {

  private NewClient newClient = new NewClient();
  private Scanner scan = new Scanner(System.in);
  private String thisInput = scan.nextLine();
  private Transaction transaction = new Transaction();

  public void checkClient() {

    List<Client> list = ClientsData.clients.stream()
        .filter(client -> client.getPhoneNumber().equals(thisInput)).collect(Collectors.toList());
    if (!list.isEmpty()) {
      RegisteredClient.registeredClient = list.get(0);
      System.out.println(RegisteredClient.registeredClient.getName() + ", welcome");
      transaction.inputMovie();
    } else {
      System.out.println("You are new user, please register ");
      newClient.registrationNewClient(thisInput);
    }
  }
}


