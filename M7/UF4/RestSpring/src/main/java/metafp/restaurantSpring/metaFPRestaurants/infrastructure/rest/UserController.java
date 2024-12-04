package metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import metafp.restaurantSpring.metaFPRestaurants.application.UserService;
import metafp.restaurantSpring.metaFPRestaurants.domain.User;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.user.CreateUserRequest;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.domain.user.CreateUserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/createUser")
  @ResponseStatus(HttpStatus.OK)
  public CreateUserResponse createUser(@RequestBody CreateUserRequest userRequest) {
    User user = new User(userRequest.name, userRequest.email);
    user = userService.createUser(user);
    return new CreateUserResponse(user.getName(), user.getEmail());
  }


  @GetMapping("/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public User getUser(@PathVariable String userId) {
    return userService.getUser(userId);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @DeleteMapping("/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
  }
}
