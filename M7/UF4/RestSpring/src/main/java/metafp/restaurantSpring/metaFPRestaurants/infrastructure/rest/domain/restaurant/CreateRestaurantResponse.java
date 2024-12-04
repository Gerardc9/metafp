package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.restaurant;

public class CreateRestaurantResponse {
  public String name; 
  public Integer capacity;
  public String foodType; 

  public CreateRestaurantResponse(String name, Integer capacity, String foodType){
    this.name = name; 
    this.capacity = capacity;
    this.foodType = foodType; 
  }
}
