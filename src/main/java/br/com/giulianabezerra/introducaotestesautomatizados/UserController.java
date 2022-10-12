package br.com.giulianabezerra.introducaotestesautomatizados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/users")
  public List<User> create(@RequestBody User user) {
    return userService.create(user);
  }
}
