package es.fercbrt.springbootcrudjpa.services.impl;

import es.fercbrt.springbootcrudjpa.entities.Role;
import es.fercbrt.springbootcrudjpa.entities.User;
import es.fercbrt.springbootcrudjpa.repositories.RoleRepository;
import es.fercbrt.springbootcrudjpa.repositories.UserRepository;
import es.fercbrt.springbootcrudjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User save(User user) {

        Optional<Role> optRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optRoleUser.ifPresent(roles::add);

        if(user.isAdmin()) {
            Optional<Role> optRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
