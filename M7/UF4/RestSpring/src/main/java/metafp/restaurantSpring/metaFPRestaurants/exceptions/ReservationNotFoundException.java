package metafp.restaurantSpring.metaFPRestaurants.exceptions;

public class ReservationNotFoundException extends RuntimeException {

  public ReservationNotFoundException(String message) {
      super(message);
  }
}
