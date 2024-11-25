package metafp.restaurantSpring.metaFPRestaurants.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurants", schema ="restapp")

public class Restaurant {

  @Id
  @Column(name="restaurant_id")
  private UUID restaurantId;

  @Column(name="name")
  private String name;

  @Column(name="capacity")
  private Integer capacity;

  @Column(name="food_type")
  private String foodType;


  public Restaurant(UUID restaurantId, String name, Integer capacity, String foodType){
    this.restaurantId = restaurantId;
    this.name = name;
    this.capacity = capacity;
    this.foodType = foodType;
  }
  
  public Restaurant(String name, Integer capacity, String foodType){
    this.restaurantId = UUID.randomUUID();
    this.name = name;
    this.capacity = capacity;
    this.foodType = foodType;
  }

  public Restaurant(){}

  public void updateDetails(Integer newCapacity, String newFoodType) {

    if (newCapacity != null) {
        this.capacity = newCapacity;
    }
    if (newFoodType != null) {
        this.foodType = newFoodType;
    }
  }

  public UUID getRestaurantId() {
    return restaurantId;
  }

  public String getName() {
      return name;
  }

  public Integer getCapacity() {
      return capacity;
  }
  public String getFoodType() {
    return foodType;
  }
}
