package es.fercbrt.springbootcrudjpa.controllers;

import es.fercbrt.springbootcrudjpa.entities.User;
import es.fercbrt.springbootcrudjpa.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors())
            return validation(bindingResult);
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid User user, BindingResult bindingResult) {
        user.setAdmin(false);
        return save(user, bindingResult);
    }

    private ResponseEntity<?> validation(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();

        bindingResult.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
