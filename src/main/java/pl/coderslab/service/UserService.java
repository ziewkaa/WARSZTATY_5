package pl.coderslab.service;

import pl.coderslab.entity.User;

import javax.transaction.Transactional;

public interface UserService {

    User findUserByEmail(String email);

    User findUserById(Long id);

    void saveUser(User user);

//    void updateUserById(Long id, String password, String lastName, String firstName, String email);
}
