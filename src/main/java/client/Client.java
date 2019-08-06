package client;

import booking.Booking;
import java.util.ArrayList;
import java.util.List;

public class Client {

  private String name;
  private String surname;
  private int age;
  private String email;
  private String phoneNumber;
  private List<Booking> bookings;

  public Client(String name, String surname, int age, String email, String phoneNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.bookings = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  @Override
  public String toString() {
    return "Client{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", age=" + age +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", bookings=" + bookings +
        '}';
  }
}

