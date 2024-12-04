package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import metafp.restaurantSpring.metaFPRestaurants.domain.Reservation;
import metafp.restaurantSpring.metaFPRestaurants.domain.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findAllByUserAndIsActive(User user, boolean isActive);
}
