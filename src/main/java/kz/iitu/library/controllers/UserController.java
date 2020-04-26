package kz.iitu.library.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import kz.iitu.library.classes.BookStatus;
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
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "user deteled"),
            @ApiResponse(code = 400, message = "Invalid user supplied"),
            @ApiResponse(code = 404, message = "user not found")})
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/find/")
    @ApiOperation(response = {
            @ApiResponse(code = 200, message = "user deteled"),
            @ApiResponse(code = 400, message = "Invalid user supplied"),
            @ApiResponse(code = 404, message = "user not found")})
    public List<User> getByNameContainingAndAge(@RequestParam String name,
                                                @RequestParam("age") Integer age) {
        return userRepository.findAllByNameContainsAndAge(name, age);
    }


}
