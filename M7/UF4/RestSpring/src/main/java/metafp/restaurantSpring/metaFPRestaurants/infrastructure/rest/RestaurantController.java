package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import metafp.restaurantSpring.metaFPRestaurants.application.RestaurantService;
import metafp.restaurantSpring.metaFPRestaurants.domain.Restaurant;
import metafp.restaurantSpring.metaFPRestaurants.exceptions.NoFieldsProvidedException;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.restaurant.CreateRestaurantRequest;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.restaurant.CreateRestaurantResponse;



@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

  @Autowired
  private RestaurantService restaurantService;

  @PostMapping("/createRestaurant")
  @ResponseStatus(HttpStatus.OK)
  public CreateRestaurantResponse createRestaurant(@RequestBody CreateRestaurantRequest restaurantRequest) {
      Restaurant restaurant = new Restaurant(restaurantRequest.name, restaurantRequest.capacity, restaurantRequest.foodType);
      restaurant = restaurantService.createRestaurant(restaurant);
      return new CreateRestaurantResponse(restaurant.getName(), restaurant.getCapacity(), restaurant.getFoodType());
  }

  @GetMapping("/{restaurantId}")
  @ResponseStatus(HttpStatus.OK)
  public Restaurant getRestaurant(@PathVariable String restaurantId) {
    return restaurantService.getRestaurant(restaurantId);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Restaurant> getAllRestaurants() {
      return restaurantService.getAllRestaurants();
  }

  @DeleteMapping("/{restaurantId}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteRestaurant(@PathVariable String restaurantId) {
      restaurantService.deleteRestaurant(restaurantId);
  }

  @PutMapping("/{restaurantId}")
  @ResponseStatus(HttpStatus.OK)
  public Restaurant updateRestaurant(
    @PathVariable String restaurantId,
    @RequestParam(required = false) Integer newCapacity,
    @RequestParam(required = false) String newFoodType,
    @RequestParam(required = false) Integer newCurrentGuests) {
      if (newCapacity == null && newFoodType == null && newCurrentGuests == null) {
        throw new NoFieldsProvidedException("Debe proporcionar al menos un campo para actualizar.");
      }
      return restaurantService.updateRestaurant(restaurantId, newCapacity, newFoodType, newCurrentGuests);
    }

}
