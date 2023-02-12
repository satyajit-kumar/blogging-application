package com.spring.project.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.Services.UserService;
import com.spring.project.payloads.ApiResponse;
import com.spring.project.payloads.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUser = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long userId) {
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteSingleUser(@PathVariable("userId") Long id) {
		this.userService.deleteSingleUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getSingleUser(@PathVariable Long userId) {
		UserDto singleUser = this.userService.getSingleUser(userId);
		return new ResponseEntity<UserDto>(singleUser, HttpStatus.FOUND);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllUsers() {
		List<UserDto> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.FOUND);
	}

	@DeleteMapping("/")
	public ResponseEntity<?> deleteAllUsers() {
		this.userService.deleteAllUsers();
		return new ResponseEntity<ApiResponse>(new ApiResponse("All Users deleted successfully", true), HttpStatus.OK);
	}
}
