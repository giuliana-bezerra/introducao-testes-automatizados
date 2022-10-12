package br.com.giulianabezerra.introducaotestesautomatizados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserIT {
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void createUser() {
    User user = new User("giulianabezerra", "123456");

    User[] users = restTemplate.postForObject("/users", user,
        User[].class);

    assertNotNull(users);
    assertEquals(1, users.length);
    assertEquals(user, users[0]);
    assertThrows(RuntimeException.class,
        () -> restTemplate.postForObject("/users",
            user, User[].class));
  }
}
