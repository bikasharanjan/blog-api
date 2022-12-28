package com.bikash.blogapi.controller;

import com.bikash.blogapi.apiresponse.ApiResponse;
import com.bikash.blogapi.binding.UserDto;
import com.bikash.blogapi.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/user/")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/createuser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PutMapping("/updateuser/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto ,@PathVariable("userId") Long userId){

        UserDto userUpdated = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(userUpdated , HttpStatus.OK);

    }

    @GetMapping("/user/{userId}")

    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){

        UserDto userById = userService.getUserById(userId);

        return new ResponseEntity<>(userById ,HttpStatus.OK);
    }
    @GetMapping("/alluser")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> allUser = userService.findAllUser();
        return new ResponseEntity<>(allUser ,HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<>(new ApiResponse("user deleted" ,true) ,HttpStatus.OK);
    }
}
