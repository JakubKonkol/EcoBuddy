package pl.pjatk.ecobuddyserver.controller;

import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.ecobuddyserver.model.Event;
import pl.pjatk.ecobuddyserver.model.User;
import pl.pjatk.ecobuddyserver.model.enums.UserStatus;
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
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {

        userService.deleteUserById(userId);
        return ResponseEntity.ok("User of id: " + userId + " has been deleted");
    }
    @PutMapping("/updatePoints/{userId}/{userPoints}")
    public ResponseEntity<User> updatePoints(@PathVariable long userId, @PathVariable long userPoints) throws Exception {
        return ResponseEntity.ok(userService.updateUserPoints(userId, userPoints));
    }
    @PutMapping("/addPoint/{userId}")
    public ResponseEntity<User> addPoint(@PathVariable long userId) throws Exception {
        return ResponseEntity.ok(userService.addOneUserPoint(userId));
    }

    @PostMapping("createEvent/{userId}")
    public ResponseEntity<Event> createEvent(@PathVariable Long userId, @RequestBody Event event) throws Exception {
        return ResponseEntity.ok(userService.createEvent(userId, event));
    }

    @PutMapping("joinEvent/{eventId}/{userId}")
    public ResponseEntity<Event> joinEvent(@PathVariable Long eventId, @PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(userService.joinEvent(eventId, userId));
    }

    @PutMapping("endEvent/{eventId}")
    public ResponseEntity<String> endEvent(Long eventId) {
        userService.endEvent(eventId);
        return ResponseEntity.ok("Event " + eventId + " został zakończony");
    }
}
