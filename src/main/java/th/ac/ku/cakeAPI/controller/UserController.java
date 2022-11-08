package th.ac.ku.cakeAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.cakeAPI.model.User;
import th.ac.ku.cakeAPI.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return service.create(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id){
        return service.getUser(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable UUID id ,@RequestBody User user){
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable UUID id){
        return service.delete(id);
    }

}
