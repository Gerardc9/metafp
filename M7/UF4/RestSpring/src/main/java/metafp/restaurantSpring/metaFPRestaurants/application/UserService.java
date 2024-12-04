package metafp.restaurantSpring.metaFPRestaurants.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import metafp.restaurantSpring.metaFPRestaurants.domain.User;
import metafp.restaurantSpring.metaFPRestaurants.exceptions.UserNotFoundException;
import metafp.restaurantSpring.metaFPRestaurants.infrastructure.rest.repositories.UserRepository;

@Component
public class UserService {

  private final UserRepository userRepository;

  @Inject
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User getUser(String userId) {
    UUID uuid = UUID.fromString(userId);
    Optional<User> userOptional = userRepository.findById(uuid);
      if (!userOptional.isPresent()) {
        throw new UserNotFoundException("No se ha podido encontrar ningún usuario con id: " + userId);
      }
    return userOptional.get();
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public void deleteUser(String userId) {
    User user = getUser(userId);
    userRepository.delete(user);
  }
}
