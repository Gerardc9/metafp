package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import metafp.restaurantSpring.metaFPRestaurants.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
