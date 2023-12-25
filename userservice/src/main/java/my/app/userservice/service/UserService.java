package my.app.userservice.service;

import my.app.userservice.bean.User;
import my.app.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByCin(String cin) {
        Optional<User> optionalUser = userRepository.findByCin(cin);
        return optionalUser.orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }
}
