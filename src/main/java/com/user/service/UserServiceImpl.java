package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserRequest;
import com.user.entity.User;
import com.user.exception.InvalidCredentialsException;
import com.user.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo userRepo;

	@Override
	public List<User> fetchAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public String saveUser(UserRequest request) {
		String message;
		User user = new User(request);
		try {
			userRepo.save(user);
			message = "Registered successfully:";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			message = "This email or phone already exists.";
		}
		return message;
	}

	@Override
	public String deleteById(Long id) {
		userRepo.deleteById(id);
		return "User deleted successfully";
	}

	@Override
	public String updateCredentials(UserRequest request) {
		User user = userRepo.findById(request.getUserId()).orElse(null);
		if (user != null && request.getHintQuestion().equals(user.getHintQuestion())) {
			user.setPassword(request.getPassword());
			userRepo.save(user);
			return "Password reset successfully:";
		} else {
			throw new InvalidCredentialsException("Invalid hint question.");
		}
	}
}
