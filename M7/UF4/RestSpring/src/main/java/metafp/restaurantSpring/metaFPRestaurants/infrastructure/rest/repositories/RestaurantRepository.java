package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.repositories;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import metafp.restaurantSpring.metaFPRestaurants.domain.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID>{
  
  Optional<Restaurant> findByRestaurantId(UUID restaurantId);

}
