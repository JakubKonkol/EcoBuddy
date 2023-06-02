package pl.pjatk.ecobuddyserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pjatk.ecobuddyserver.model.User;
import pl.pjatk.ecobuddyserver.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        var optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("There's no task with given id");
        }
        return optionalUser.get();
    }

    public User updateUserById(long id, User user) throws Exception {
        if (user != null) {
            User updatedUser = userRepository.findById(id).orElseThrow();
            updatedUser.setNickname(user.getNickname());
            updatedUser.setPoints(user.getPoints());
//            updatedUser.setTaskHistory(user.getTaskHistory()); //TODO: dodać po stworzeniu taska
            return updatedUser;
        }

        throw new Exception("Something went wrong");
    }

    public void deleteUserById(long id) {
        var optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("There's no task with given id");
        }

        userRepository.delete(optionalUser.get());
    }

}
