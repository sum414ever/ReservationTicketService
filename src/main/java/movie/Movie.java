package movie;

import hall.Hall;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {

  private BigDecimal bigDecimal;
  private String name;
  private int numberOfRoom;
  private TypeOfMovie typeOfMovie;
  private StatusOfMovie statusOfMovie;
  private LocalDate durationFrom;
  private LocalDate durationTo;
  private BigDecimal priceNormal  ;
  private BigDecimal pricePremium;
  private BigDecimal priceVip;
  private Category category;
  private List<Hall> halls = new ArrayList<>();

  public Movie(String name, int numberOfRoom, TypeOfMovie typeOfMovie,
      StatusOfMovie statusOfMovie, String durationFrom, String durationTo, double priceNormal,
      double pricePremium, double priceVip, Category category) {

    this.name = name;
    this.numberOfRoom = numberOfRoom;
    this.typeOfMovie = typeOfMovie;
    this.statusOfMovie = statusOfMovie;
    this.durationFrom = LocalDate.parse(durationFrom);
    this.durationTo = LocalDate.parse(durationTo);
    this.priceNormal = new BigDecimal(priceNormal);
    this.pricePremium = new BigDecimal(pricePremium);
    this.priceVip = new BigDecimal(priceVip);
    this.category = category;
    //adds to each film a list of places for every day
    for (int i = 0; i < Duration.between(this.durationFrom.atStartOfDay(), this.durationTo.atStartOfDay()).toDays(); i++) {
      halls.add(new Hall(numberOfRoom, this.durationFrom.plusDays(i)));
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumberOfRoom() {
    return numberOfRoom;
  }

  public void setNumberOfRoom(int numberOfRoom) {
    this.numberOfRoom = numberOfRoom;
  }

  public TypeOfMovie getTypeOfMovie() {
    return typeOfMovie;
  }

  public void setTypeOfMovie(TypeOfMovie typeOfMovie) {
    this.typeOfMovie = typeOfMovie;
  }

  public StatusOfMovie getStatusOfMovie() {
    return statusOfMovie;
  }

  public void setStatusOfMovie(StatusOfMovie statusOfMovie) {
    this.statusOfMovie = statusOfMovie;
  }

  public LocalDate getDurationFrom() {
    return durationFrom;
  }

  public void setDurationFrom(LocalDate durationFrom) {
    this.durationFrom = durationFrom;
  }

  public LocalDate getDurationTo() {
    return durationTo;
  }

  public void setDurationTo(LocalDate durationTo) {
    this.durationTo = durationTo;
  }

  public BigDecimal getPriceNormal() {
    return priceNormal;
  }

  public void setPriceNormal(BigDecimal priceNormal) {
    this.priceNormal = priceNormal;
  }

  public BigDecimal getPricePremium() {
    return pricePremium;
  }

  public void setPricePremium(BigDecimal pricePremium) {
    this.pricePremium = pricePremium;
  }

  public BigDecimal getPriceVip() {
    return priceVip;
  }

  public void setPriceVip(BigDecimal priceVip) {
    this.priceVip = priceVip;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public BigDecimal getBigDecimal() {
    return bigDecimal;
  }

  public void setBigDecimal(BigDecimal bigDecimal) {
    this.bigDecimal = bigDecimal;
  }

  public List<Hall> getHalls() {
    return halls;
  }

  public void setHalls(List<Hall> halls) {
    this.halls = halls;
  }

  @Override
  public String toString() {
    return "movie.Movie{" +
        "name='" + name + '\'' +
        ", numberOfRoom=" + numberOfRoom +
        ", typeOfMovie=" + typeOfMovie +
        ", statusOfMovie=" + statusOfMovie +
        ", durationFrom=" + durationFrom +
        ", durationTo=" + durationTo +
        ", priceNormal=" + priceNormal +
        ", pricePremium=" + pricePremium +
        ", priceVip=" + priceVip +
        ", category=" + category +
        '}';
  }
}
