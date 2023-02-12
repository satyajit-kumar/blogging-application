package com.spring.project.ServicesImpls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.Services.UserService;
import com.spring.project.entities.User;
import com.spring.project.exceptions.ResourceNotFoundException;
import com.spring.project.payloads.UserDto;
import com.spring.project.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		return this.userToDto(this.userRepository.save(user));
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		user.setUserName(userDto.getUserName());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserInfo(userDto.getUserInfo());

		return this.userToDto(this.userRepository.save(user));
	}

	@Override
	public UserDto getSingleUser(Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> allUsers = this.userRepository.findAll().stream().map(s -> this.userToDto(s))
				.collect(Collectors.toList());
		return allUsers;
	}

	@Override
	public void deleteSingleUser(Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepository.delete(user);
	}

	@Override
	public void deleteAllUsers() {
		this.userRepository.deleteAll();
	}

	public UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

	public User dtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}

}
