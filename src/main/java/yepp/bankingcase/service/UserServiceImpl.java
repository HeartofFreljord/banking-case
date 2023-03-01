package yepp.bankingcase.service;

import org.springframework.stereotype.Component;
import yepp.bankingcase.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final List<User> userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
    }

    @Override
    public User getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userList.stream().filter(user -> user.getName().equals(name)).findFirst().stream().toList();
    }

    @Override
    public User createUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }

    @Override
    public User updateUser(int id, User newUser) {
        if (id < userList.size()) {
            userList.set(id, newUser);
            return newUser;
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
