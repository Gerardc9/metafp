package metafp.restaurantSpring.metaFPRestaurants.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users", schema = "restapp")
public class User {

    @Id
    @Column(name = "user_id")
    private final UUID userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Constructores
    public User() {
        this.userId = UUID.randomUUID();
    }

    public User(String name, String email) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    // Getters y Setters
    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
