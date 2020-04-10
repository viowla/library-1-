package kz.iitu.library.controllers;

import kz.iitu.library.classes.User;
import kz.iitu.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<User> getByNameContainingAndAge(@RequestParam String name,
                                                @RequestParam("age") Integer age) {
        return userRepository.findAllByNameContainsAndAge(name, age);
    }
}
