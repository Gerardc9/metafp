package metafp.restaurantSpring.metaFPRestaurants.application;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import metafp.restaurantSpring.metaFPRestaurants.domain.Reservation;
import metafp.restaurantSpring.metaFPRestaurants.domain.Restaurant;
import metafp.restaurantSpring.metaFPRestaurants.domain.User;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.repositories.ReservationRepository;

@Component
public class ReservationService {

  private final ReservationRepository reservationRepository;
  private final UserService userService;
  private final RestaurantService restaurantService;

  @Inject
  public ReservationService(ReservationRepository reservationRepository, UserService userService, RestaurantService restaurantService) {
    this.reservationRepository = reservationRepository;
    this.userService = userService;
    this.restaurantService = restaurantService;
  }

  public Reservation createReservation(String userId, String restaurantId, Integer numberOfGuests) {
    User user = userService.getUser(userId);
    Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

    if (restaurant.getCapacity() < numberOfGuests) {
        throw new RuntimeException("Lo sentimos, no disponemos en estos momentos de aforo disponible para su reserva.");
    }

    int updatedCapacity = restaurant.getCapacity() - numberOfGuests;
    int updatedCurrentGuests = restaurant.getCurrentGuests() + numberOfGuests;
    restaurantService.updateRestaurant(restaurantId, updatedCapacity, null, updatedCurrentGuests);

    Reservation reservation = new Reservation(user, restaurant, numberOfGuests, true);
    return reservationRepository.save(reservation);
  }

  public void cancelReservation(String userId) {
    User user = userService.getUser(userId);
    List<Reservation> activeReservations = reservationRepository.findAllByUserAndIsActive(user, true);

    if (activeReservations.isEmpty()) {
        throw new RuntimeException("No se ha encontrado ninguna reserva activa asociada a este usuario.");
    }

    for (Reservation reservation : activeReservations) {
        reservation.setIsActive(false);

        Restaurant restaurant = reservation.getRestaurant();
        int updatedCapacity = restaurant.getCapacity() + reservation.getNumberOfGuests();
        int updatedCurrentGuests = restaurant.getCurrentGuests() - reservation.getNumberOfGuests();

        restaurantService.updateRestaurant(restaurant.getRestaurantId().toString(), updatedCapacity, null, updatedCurrentGuests);

        reservationRepository.save(reservation);
    }
}

}
