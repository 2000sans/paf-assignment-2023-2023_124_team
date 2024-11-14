package uni.sliit.pafproject.controller;


import uni.sliit.pafproject.model.User;
import uni.sliit.pafproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService user_service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return user_service.addUser(user);
    }
    @GetMapping
    public List<User> getUsers(){
        return user_service.findAllUsers();

    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return user_service.getUserByUserId(userId);
    }
    @GetMapping("/user_type/{userType}")
    public List<User> findUserUsingUserType(@PathVariable String userType){
        return user_service.getUserByUserType(userType);
    }
    @GetMapping("/user_name/{userName}")
    public List<User>  findUserUsingUserName(@PathVariable String userName){
        return user_service.getUserByUserName(userName);
    }
    @PutMapping
    public User modifyUser(@RequestBody User user){
        return user_service.updateUserDetails(user);

    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return user_service.deleteUser(userId);
    }
}
