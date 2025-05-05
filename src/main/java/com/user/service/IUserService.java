package com.user.service;

import java.util.List;

import com.user.dto.UserRequest;
import com.user.entity.User;

public interface IUserService {

	List<User> fetchAllUsers();

	String saveUser(UserRequest request);

	String deleteById(Long id);

	String updateCredentials(UserRequest request);
}
