package com.tms.controller;
import com.tms.domain.UserInfo;
import com.tms.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserInfo> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable Integer id) {
        return  userService.getUser(id);
    }

    @PostMapping
    public String createUser(@RequestBody UserInfo userInfo) {
        userService.createUser(userInfo);
        return "OK";
    }

    @PutMapping
    public String updateUser(@RequestBody UserInfo userInfo) {
        userService.updateUser(userInfo);
        return "OK";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "OK";
    }
}
