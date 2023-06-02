package pl.pjatk.ecobuddyserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.ecobuddyserver.model.User;
import pl.pjatk.ecobuddyserver.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId,
                                           @RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.updateUserById(userId, user));
    }

    @DeleteMapping("/deleteById{userId}")
    public ResponseEntity<String> deleteTask(@PathVariable long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User of id: " + userId + " has been deleted");
    }

    @PutMapping("/updateUserPoints/{userId}/{points}")
    public ResponseEntity<String> updateUserPoints(@PathVariable Long userId,
                                                 @PathVariable Long points) throws Exception {
        userService.updateUserPoints(userId,points);
        return ResponseEntity.ok("Added " + points + " to user " + userId + " account");
    }
}
