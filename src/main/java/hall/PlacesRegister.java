package hall;

import java.util.ArrayList;
import java.util.List;
import movie.TypeOfPlaces;

public class PlacesRegister {

  private static final int maxNormalRowNumber = 5;
  private static final int maxPremiumRowNumber = 10;
  private static final int maxVipRowNumber = 15;
  private static final int maxPlaceNumber = 10;

  //this method adds 5 rows 10 places each for each type of place
  public List<Place> registerOfPlaces() {
    List<Place> places = new ArrayList<>();
    for (int j = 1; j < maxNormalRowNumber + 1; j++) {
      for (int k = 1; k < maxPlaceNumber + 1; k++) {
        places.add(new Place(false, j, k, TypeOfPlaces.NORMAL));
      }
    }
    for (int j = 6; j < maxPremiumRowNumber + 1; j++) {
      for (int k = 1; k < maxPlaceNumber + 1; k++) {
        places.add(new Place(false, j, k, TypeOfPlaces.PREMIUM));
      }
    }
    for (int j = 11; j < maxVipRowNumber + 1; j++) {
      for (int k = 1; k < maxPlaceNumber + 1; k++) {
        places.add(new Place(false, j, k, TypeOfPlaces.VIP));
      }
    }
    return places;
  }
}