package yepp.bankingcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yepp.bankingcase.model.User;
import yepp.bankingcase.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{uid}")
    public User getUser(@PathVariable int uid) {
        return this.userService.getUserById(uid);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User newUser) {
        if (newUser != null) {
            this.userService.createUser(newUser);
            return newUser;
        }
        return null;
    }

    @PutMapping(value = "/user/{uid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable int uid, @RequestBody User newUser) {
        if (newUser != null) {
            return this.userService.updateUser(uid, newUser);
        }
        return null;
    }

    @DeleteMapping(value = "/user/{uid}")
    public void deleteUser(@PathVariable int uid) {
        this.userService.deleteUser(uid);
    }
}
