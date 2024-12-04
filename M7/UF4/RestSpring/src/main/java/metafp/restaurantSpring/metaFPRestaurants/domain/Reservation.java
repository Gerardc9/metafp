package metafp.restaurantSpring.metaFPRestaurants.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations", schema = "restapp")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    private final UUID reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "number_of_guests", nullable = false)
    private Integer numberOfGuests;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    // Constructores
    public Reservation() {
        this.reservationId = UUID.randomUUID();
    }

    public Reservation(User user, Restaurant restaurant, Integer numberOfGuests, Boolean isActive) {
        this.reservationId = UUID.randomUUID();
        this.user = user;
        this.restaurant = restaurant;
        this.numberOfGuests = numberOfGuests;
        this.isActive = isActive;
    }

    // Getters y Setters
    public UUID getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
