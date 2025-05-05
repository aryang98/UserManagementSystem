package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.user.dto.GeneralResponseDTO;
import com.user.dto.UserRequest;
import com.user.entity.User;
import com.user.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/home")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public ResponseEntity<GeneralResponseDTO> getAllUsers() {
		List<User> userList = userService.fetchAllUsers();
		GeneralResponseDTO responseDTO = new GeneralResponseDTO("List of users ", userList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<GeneralResponseDTO> saveUser(@Valid @RequestBody UserRequest request) {
		String message = userService.saveUser(request);
		GeneralResponseDTO responseDTO = new GeneralResponseDTO("message", message);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/resetCredentials")
	public ResponseEntity<GeneralResponseDTO> updateCredentials(@RequestBody UserRequest request) {
		String message = userService.updateCredentials(request);
		GeneralResponseDTO responseDTO = new GeneralResponseDTO("message", message);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<GeneralResponseDTO> deleteUser(@PathVariable("id") Long id) {
		String message = userService.deleteById(id);
		GeneralResponseDTO responseDTO = new GeneralResponseDTO("message", message);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
