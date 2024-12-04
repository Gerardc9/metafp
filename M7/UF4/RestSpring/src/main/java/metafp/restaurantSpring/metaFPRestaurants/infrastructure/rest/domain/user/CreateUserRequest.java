package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.user;

import jakarta.validation.constraints.NotNull;

public class CreateUserRequest {
  
    @NotNull
    public String name;

    @NotNull
    public String email;
}
