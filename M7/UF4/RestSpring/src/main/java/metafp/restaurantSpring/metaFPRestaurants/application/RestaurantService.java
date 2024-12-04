package metafp.restaurantSpring.metaFPRestaurants.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import metafp.restaurantSpring.metaFPRestaurants.domain.Restaurant;
import metafp.restaurantSpring.metaFPRestaurants.exceptions.RestaurantNotFoundException;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.repositories.RestaurantRepository;


@Component
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  @Inject
  public RestaurantService(RestaurantRepository restaurantRepository){
    this.restaurantRepository = restaurantRepository;
  }

  public Restaurant createRestaurant(Restaurant restaurant){
    return restaurantRepository.save(restaurant);
  }

  public Restaurant getRestaurant(String restaurantId){
    UUID uuidRestaurant = UUID.fromString(restaurantId);
    Optional<Restaurant> restaurantOptional = restaurantRepository.findById(uuidRestaurant);
    if(!restaurantOptional.isPresent()){
      throw new RestaurantNotFoundException("No se ha encontrado ningún restaurante con la ID: " + restaurantId);
    }
    return restaurantOptional.get();
  }

  public List<Restaurant> getAllRestaurants(){
    return restaurantRepository.findAll();
  }

  public Restaurant updateRestaurant(String id, Integer newCapacity, String newFoodType, Integer newCurrentGuests) {
    Restaurant restaurant = getRestaurant(id);
    restaurant.updateDetails(newCapacity, newFoodType);

    if (newCurrentGuests != null) {
      restaurant.setCurrentGuests(newCurrentGuests);
    }
  
    return restaurantRepository.save(restaurant); 
  }

  public void deleteRestaurant(String id){
    Restaurant restaurant = getRestaurant(id);
    restaurantRepository.delete(restaurant);
  }

}
