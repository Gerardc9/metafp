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

  @Column(name="name", nullable = false)
  private String name;

  @Column(name="capacity", nullable = false)
  private Integer capacity;

  @Column(name="food_type", nullable = false)
  private String foodType;

  @Column(name="current_guests")
  private Integer currentGuests;


  public Restaurant(UUID restaurantId, String name, Integer capacity, String foodType){
    this.restaurantId = restaurantId;
    this.name = name;
    this.capacity = capacity;
    this.foodType = foodType;
    this.currentGuests = 0;
  }
  
  public Restaurant(String name, Integer capacity, String foodType){
    this.restaurantId = UUID.randomUUID();
    this.name = name;
    this.capacity = capacity;
    this.foodType = foodType;
    this.currentGuests = 0;
  }

  public Restaurant(){
    this.currentGuests = 0;
  }

  public void updateDetails(Integer newCapacity, String newFoodType) {

    if (newCapacity != null) {
        this.capacity = newCapacity;
    }
    if (newFoodType != null) {
        this.foodType = newFoodType;
    }
  }

  //Getters 
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

  public Integer getCurrentGuests() {
    return currentGuests;
  }

  //Setters
  public void setCurrentGuests(Integer currentGuests) {
    this.currentGuests = currentGuests;
  }
}
