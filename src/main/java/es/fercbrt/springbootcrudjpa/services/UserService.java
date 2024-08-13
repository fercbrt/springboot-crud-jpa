package es.fercbrt.springbootcrudjpa.services;

import es.fercbrt.springbootcrudjpa.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);
}
