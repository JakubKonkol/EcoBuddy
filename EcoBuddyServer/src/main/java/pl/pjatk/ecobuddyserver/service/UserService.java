package pl.pjatk.ecobuddyserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.ecobuddyserver.model.Event;
import pl.pjatk.ecobuddyserver.model.User;
import pl.pjatk.ecobuddyserver.model.enums.UserStatus;
import pl.pjatk.ecobuddyserver.repository.EventRepository;
import pl.pjatk.ecobuddyserver.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public User save(User user) {
        user.setUserStatus(UserStatus.NEUTRAL); //Default NEUTRAL Status
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        var optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("There's no User with given id");
        }
        return optionalUser.get();
    }

    public User updateUserById(long id, User user) throws Exception {
        if (user != null) {
            User updatedUser = userRepository.findById(id).orElseThrow();
            updatedUser.setIdUser(id);
            updatedUser.setNickname(user.getNickname());
            updatedUser.setPoints(user.getPoints());
            userRepository.save(updatedUser);
            return updatedUser;
        }
        throw new Exception("Something went wrong");
    }

    public void deleteUserById(long id) {
        var optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("There's no User with given id");
        }

        userRepository.delete(optionalUser.get());
    }

    public User updateUserPoints(Long id, Long points) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().setPoints((user.get().getPoints()) + points);
            updateUserById(id, user.get());
            return user.get();
        }
        else{
            throw new NoSuchElementException("There's no user with given id");
        }
    }
    public User addOneUserPoint(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().setPoints((user.get().getPoints()) + 1);
            updateUserById(id, user.get());
            return user.get();
        }
        else{
            throw new NoSuchElementException("There's no user with given id");
        }
    }

    //TODO: join event i create event

    public void updateUserStatus(Long id, UserStatus userStatus) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setUserStatus(userStatus);
            updateUserById(id, user.get());
        }
    }
    public Event createEvent(Long userId, Event event) throws Exception {
        updateUserStatus(userId, UserStatus.HOST);
        User host = getUserById(userId);
        event.setCompleted(false);
        Event newEvent = eventRepository.save(event);
        host.setEvent(newEvent);
        newEvent.getParticipants().add(host);
        return eventRepository.save(newEvent);
    }

    public Event joinEvent(Long eventId, Long userId) throws Exception {
        Optional<Event> event = eventRepository.findById(eventId);
        Optional<User> user = userRepository.findById(userId);

        if (event.isEmpty() || user.isEmpty()) {
            throw new NoSuchElementException("Nie ma takiego eventu lub usera");
        }
        updateUserStatus(user.get().getIdUser(), UserStatus.PARTICIPANT);
        user.get().setEvent(event.get());
        event.get().getParticipants().add(user.get());
        return eventRepository.save(event.get());
    }

    //TODO: zrobic metode ktora bedzie sprawdzac czy eventy zostaly wykonane (Lista eventow)
//    @Scheduled(fixedRate = 5000) // Wykonuje się co 5 sekund w celach demonstracyjnych
//    public void endEvent(Long eventId) {
//        LocalDateTime currentDate = LocalDateTime.now();
//        LocalDateTime targetDate = LocalDateTime.of(2023, 6, 3, 12, 0, 0); // Twoja docelowa data
//
//        if (currentDate.isAfter(targetDate)) {
//            // Wykonaj swoje działanie
//            System.out.println("Wykonuję działanie po dacie " + targetDate);
//        }
//    }
    public void endEvent(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isEmpty()){
            throw new NoSuchElementException("Nie ma takiego eventu");
        }
        event.get().setCompleted(true);
        event.get().getParticipants().forEach(p -> {
            try {
                if (p.getUserStatus().equals(UserStatus.HOST)) {
                    updateUserStatus(p.getIdUser(), UserStatus.NEUTRAL);
                }
                updateUserStatus(p.getIdUser(), UserStatus.NEUTRAL);
                p.setEvent(null); //TODO: sprawdzic czy null dla tego eventu czy dal wszystkich
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            event.get().setParticipants(null);
            eventRepository.save(event.get());
        });
    }
}
