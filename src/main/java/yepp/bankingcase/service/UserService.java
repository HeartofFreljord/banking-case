package yepp.bankingcase.service;

import yepp.bankingcase.model.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    List<User> getUsersByName(String name);

    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
