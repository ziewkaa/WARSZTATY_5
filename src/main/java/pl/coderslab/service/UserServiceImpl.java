package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

//    @Override
//    public void updateUserById(Long id, String password, String lastName, String firstName, String email) {
//        userRepository.updateUserById(password,email,firstName,lastName,id);
//    }

}



