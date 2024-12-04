package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.user;

public class CreateUserResponse {
  public String name;
  public String email;

  public CreateUserResponse(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
