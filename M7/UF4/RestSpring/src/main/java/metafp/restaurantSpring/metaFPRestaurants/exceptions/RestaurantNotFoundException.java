package metafp.restaurantSpring.metaFPRestaurants.exceptions;

public class RestaurantNotFoundException extends RuntimeException {

  public RestaurantNotFoundException(String message) {
      super(message);
  }
}
