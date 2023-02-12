package com.spring.project.Services;

import java.util.List;

import com.spring.project.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Long userId);

	UserDto getSingleUser(Long userId);

	List<UserDto> getAllUsers();

	void deleteSingleUser(Long userId);

	void deleteAllUsers();
}
