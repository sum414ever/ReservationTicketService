package cinema;

import java.util.List;
import movie.Movie;

public class Cinema {

  private String name;
  private String address;
  private String rating;
  private List<Movie> movies;

  public Cinema(String name, String address, String rating, List<Movie> movies) {

    this.name = name;
    this.address = address;
    this.rating = rating;
    this.movies = movies;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getAddress() {

    return address;
  }

  public void setAddress(String address) {

    this.address = address;
  }

  public String getRating() {

    return rating;
  }

  public void setRating(String rating) {

    this.rating = rating;
  }

  public java.util.List<Movie> getMovies() {

    return movies;
  }

  public void setMovies(java.util.List<Movie> movies) {

    this.movies = movies;
  }

  @Override
  public String toString() {
    return "Cinema{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", rating='" + rating + '\'' +
        ", movies=" + movies +
        '}';
  }
}
