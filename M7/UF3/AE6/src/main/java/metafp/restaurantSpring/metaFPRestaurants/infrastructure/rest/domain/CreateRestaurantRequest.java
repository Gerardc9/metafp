package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain;

import jakarta.validation.constraints.NotNull;

public class CreateRestaurantRequest {
  @NotNull
  public String name; 
  @NotNull
  public Integer capacity;
  @NotNull
  public String foodType; 
}
