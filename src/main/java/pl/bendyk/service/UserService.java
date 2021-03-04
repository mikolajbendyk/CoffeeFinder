package pl.bendyk.service;

import pl.bendyk.model.auth.User;

public interface UserService {

    User findByUsername(String name);
    void saveUser(User user);

}
