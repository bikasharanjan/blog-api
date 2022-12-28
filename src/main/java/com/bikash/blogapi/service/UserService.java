package com.bikash.blogapi.service;

import com.bikash.blogapi.binding.UserDto;

import java.util.List;

public interface UserService {

    // todo : abstract methods

  UserDto createUser(UserDto userDto);

  UserDto updateUser(UserDto userDto , long userId);

  UserDto getUserById(long userId);

  List<UserDto> findAllUser();

  void deleteUserById(long userId);

}
