package com.tms.controller;
import com.tms.domain.Role;
import com.tms.domain.UserInfo;
import com.tms.exception.UserNotFoundException;
import com.tms.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //для REST архитектуры
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserInfo>> getUsers() {
        List<UserInfo> users = userService.getUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }
    @GetMapping("/all/{role}")
    public ResponseEntity<List<UserInfo>> getUsersByRole(@PathVariable String role) {
        List<UserInfo> users = userService.findAllByRole(Role.valueOf(role));
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }
    @GetMapping("/last/{lastName}")
   public ResponseEntity<UserInfo> getUserByLastName(@PathVariable String lastName){
        UserInfo user = userService.findUsersByLastName(lastName).orElseThrow(UserNotFoundException::new);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUser(@PathVariable @Parameter(description = "Это id пользователя") Integer id) {
        UserInfo user = userService.getUser(id).orElseThrow(UserNotFoundException::new);
      return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @Operation(summary = "Добавляем пользователя", description = "Мы добавляем пользователя, нужно на вход передать json UserInfo!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Мы успешно создали пользователя"),
            @ApiResponse(responseCode = "409", description = "Не получилось создать пользователя"),
            @ApiResponse(responseCode = "400", description = "Ошибка со стороны клиента"),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере")
    })
    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Parameter(description = "пользователь которого добавляем") UserInfo userInfo) {
        userService.createUser(userInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Tag(name = "Test tag", description = "This is our test tag description!")
    @PutMapping
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserInfo userInfo) {
        userService.updateUser(userInfo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}