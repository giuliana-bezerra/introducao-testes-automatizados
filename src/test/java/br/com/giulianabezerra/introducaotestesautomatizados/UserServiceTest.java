package br.com.giulianabezerra.introducaotestesautomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
  private UserService userService = new UserService();

  @Test
  public void createUser_ReturnsUsers() {
    // AAA
    // Arrange
    User user = new User("giulianabezerra", "123456");

    // Act
    List<User> users = userService.create(user);

    // Assert
    assertEquals(1, users.size());
    assertEquals(user, users.get(0));
  }

  @Test
  public void createUser_ThrowsException() {
    User user = new User("giulianabezerra", "123456");
    userService.create(user);

    assertThrows(RuntimeException.class,
        () -> userService.create(user));
  }
}
