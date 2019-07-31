package hall;

import java.time.LocalDate;
import java.util.List;

public class Hall {

  private int number;
  private PlacesRegister placesRegister = new PlacesRegister();
  private List<Place> places;
  private LocalDate date;

  public Hall(int number, LocalDate date) {
    this.number = number;
    this.date = date;
    this.places = placesRegister.registerOfPlaces();
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public PlacesRegister getPlacesRegister() {
    return placesRegister;
  }

  public void setPlacesRegister(PlacesRegister placesRegister) {
    this.placesRegister = placesRegister;
  }

  public List<Place> getPlaces() {
    return places;
  }

  public void setPlaces(List<Place> places) {
    this.places = places;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "hall.Hall{" +
        "number=" + number +
        ", bookingPlaces=" + placesRegister +
        '}';
  }
}
