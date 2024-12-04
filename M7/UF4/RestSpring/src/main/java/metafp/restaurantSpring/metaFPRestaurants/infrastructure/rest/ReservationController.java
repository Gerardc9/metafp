package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import metafp.restaurantSpring.metaFPRestaurants.application.ReservationService;
import metafp.restaurantSpring.metaFPRestaurants.domain.Reservation;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Reservation createReservation(
            @RequestParam String userId,
            @RequestParam String restaurantId,
            @RequestParam Integer numberOfGuests) {
        return reservationService.createReservation(userId, restaurantId, numberOfGuests);
    }

    @PutMapping("/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelReservations(@RequestParam String userId) {
        reservationService.cancelReservation(userId);
    }
}
