package hall;

import movie.TypeOfPlaces;

public class Place {

  private boolean isBusy;
  private int rowNumber;
  private int placeNumber;
  private TypeOfPlaces typeOfPlaces;

  public Place(boolean isBusy, int rowNumber, int placeNumber, TypeOfPlaces typeOfPlaces) {
    this.isBusy = isBusy;
    this.rowNumber = rowNumber;
    this.placeNumber = placeNumber;
    this.typeOfPlaces = typeOfPlaces;
  }

  public boolean isBusy() {
    return isBusy;
  }

  public void setBusy(boolean busy) {
    isBusy = busy;
  }

  public int getRowNumber() {
    return rowNumber;
  }

  public void setRowNumber(int rowNumber) {
    this.rowNumber = rowNumber;
  }

  public int getPlaceNumber() {
    return placeNumber;
  }

  public void setPlaceNumber(int placeNumber) {
    this.placeNumber = placeNumber;
  }

  public TypeOfPlaces getTypeOfPlaces() {
    return typeOfPlaces;
  }

  public void setTypeOfPlaces(TypeOfPlaces typeOfPlaces) {
    this.typeOfPlaces = typeOfPlaces;
  }

  @Override
  public String toString() {
    return "Place{" +
        "isBusy=" + isBusy +
        ", rowNumber=" + rowNumber +
        ", placeNumber=" + placeNumber +
        ", typeOfPlaces=" + typeOfPlaces +
        '}';
  }
}
