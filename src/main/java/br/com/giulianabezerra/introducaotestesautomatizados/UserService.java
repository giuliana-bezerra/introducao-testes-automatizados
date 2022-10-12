package br.com.giulianabezerra.introducaotestesautomatizados;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  List<User> users = new ArrayList<>();

  public List<User> create(User user) {
    if (isUsernameAlreadyInUse(user))
      throw new RuntimeException();

    users.add(user);
    return users;
  }

  private boolean isUsernameAlreadyInUse(User newUser) {
    return users.stream()
        .filter(user -> user.username().equals(newUser.username()))
        .findAny()
        .isPresent();
  }
}
