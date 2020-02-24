package com.bontsi.assessment.globalkinectic.GlobalKinectic;

import com.bontsi.assessment.globalkinectic.GlobalKinectic.model.User;
import com.bontsi.assessment.globalkinectic.GlobalKinectic.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UsersController {

    @Autowired
    private UserRepository repository;

    // Find
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/login")
    User Login(@PathVariable String username,@PathVariable String password) {
        User user =repository.findByUsernameAndPassword(username,password);
        if(user ==null){
            return "invalid login";
        }

        return user;
    }

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("users")
    User newUser(@RequestBody User newBook) {
        return repository.save(newBook);
    }

    // Find
    @GetMapping("/logout{id}")
    void findOne(@PathVariable Long id) {
         repository.findById(id);
    }

    // Save or update
    @PutMapping("/users")
    User saveOrUpdate(@PathVariable String username,@PathVariable String phone,@PathVariable String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPhone(phone);
        newUser.setPassword(password);
        repository.save(newUser);
         return newUser;
    }

    // update author only
    @PostMapping("/books/{id}")
    void patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

         repository.findById(id);

    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
