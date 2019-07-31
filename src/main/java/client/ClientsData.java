package client;

import java.util.ArrayList;
import java.util.List;

public class ClientsData {

  public static List<Client> clients = new ArrayList<>();

  static {
    clients.add(new Client("Alex", "Soroka", 30, "40a.gmail.com", "0935554433"));
    clients.add(new Client("Oleg", "Petrov", 20, "petrovoleg.gmail.com", "0992223311"));
    clients.add(new Client("Igor", "Ivanov", 19, "ivanov.gmail.com", "0668887755"));
    clients.add(new Client("Yuriy", "Sidorov", 45, "sidorov.gmail.com", "0558885522"));
  }
}
