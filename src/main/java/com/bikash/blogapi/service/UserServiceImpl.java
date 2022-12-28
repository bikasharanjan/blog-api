package com.bikash.blogapi.service;

import com.bikash.blogapi.binding.UserDto;
import com.bikash.blogapi.entity.UserEntity;
import com.bikash.blogapi.exception.ResourceNotFoundException;
import com.bikash.blogapi.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    // todo : creating and saving user in database
    @Override
    public UserDto createUser(UserDto userDto) {

        UserEntity userEntity = dtoToUser(userDto);
        UserEntity savedUser = userRepo.save(userEntity);
        UserDto  userDtoResponse= userToDto(savedUser);
        return userDtoResponse;
    }

    /**
     * @param userDto
     * @return
     */
    @Override
    public UserDto updateUser(UserDto userDto , long userId) {

        UserEntity updatedUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        updatedUser.setFirstName(userDto.getFirstName());
        updatedUser.setLastName(userDto.getLastName());
        updatedUser.setPassword(userDto.getPassword());
        updatedUser.setAboutUser(userDto.getAboutUser());
        // convert user to dto
        UserEntity saved = userRepo.save(updatedUser);
        UserDto userDtoResponse = userToDto(saved);
        return userDtoResponse;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public UserDto getUserById(long userId) {

        UserEntity userEntity = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        UserDto userDto = userToDto(userEntity);
        return userDto;
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> findAllUser() {
        List<UserEntity> allUser = userRepo.findAll();
        List<UserDto> collectDtoToEntity = allUser.stream().map(users -> userToDto(users)).collect(Collectors.toList());
        return collectDtoToEntity;
    }

    /**
     * @param userId 
     */
    @Override
    public void deleteUserById(long userId) {

        UserEntity getUserId = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepo.deleteById(userId);

    }
    private UserEntity dtoToUser(UserDto userDto){

        UserEntity userEntity=new UserEntity();
            modelMapper.map(userDto ,userEntity);
//        userEntity.setFirstName(userDto.getFirstName());
//        userEntity.setLastName(userDto.getLastName());
//        userEntity.setEmail(userDto.getEmail());
//        userEntity.setPassword(userDto.getPassword());
//        userEntity.setAboutUser(userDto.getAboutUser());
        return userEntity;

    }
    private UserDto userToDto(UserEntity userEntity){

        UserDto userDto=new UserDto();

        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setAboutUser(userEntity.getAboutUser());
        return userDto;

    }
}
