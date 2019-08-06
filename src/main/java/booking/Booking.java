package booking;

import hall.Hall;
import hall.Place;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import movie.Movie;

public class Booking {

  private LocalDate bookedDate;
  private boolean paymentStatus;
  private Movie bookedMovie;
  private String row;
  private String place;
  private BigDecimal price;

  public Booking(LocalDate bookedDate, boolean paymentStatus, Movie bookedMovie, String row,
      String place, BigDecimal price) {
    this.bookedDate = bookedDate;
    this.paymentStatus = paymentStatus;
    this.bookedMovie = bookedMovie;
    this.row = row;
    this.place = place;
    this.price = price;

    //When place is reserve, change it in boolean
    List<Hall> collect = bookedMovie.getHalls().stream()
        .filter(hall -> hall.getDate()
            .equals(this.bookedDate)).collect(Collectors.toList());
    for (Place p : collect.get(0).getPlaces()) {
      if (p.getPlaceNumber() == Integer.parseInt(place) && p.getRowNumber() == Integer
          .parseInt(row)) {
        p.setBusy(true);
      }
    }
  }

  public LocalDate getBookedDate() {
    return bookedDate;
  }

  public void setBookedDate(LocalDate bookedDate) {
    this.bookedDate = bookedDate;
  }

  public boolean getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(boolean paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public Movie getBookedMovie() {
    return bookedMovie;
  }

  public void setBookedMovie(Movie bookedMovie) {
    this.bookedMovie = bookedMovie;
  }

  public String getRow() {
    return row;
  }

  public void setRow(String row) {
    this.row = row;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Booking{" +
        "bookedDate=" + bookedDate +
        ", paymentStatus=" + paymentStatus +
        ", bookedMovie=" + bookedMovie +
        ", row='" + row + '\'' +
        ", place='" + place + '\'' +
        ", price=" + price +
        '}';
  }
}
