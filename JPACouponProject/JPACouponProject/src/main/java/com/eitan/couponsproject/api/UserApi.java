package com.eitan.couponsproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eitan.couponsproject.entities.User;
import com.eitan.couponsproject.data.LoginResponseDataObject;
import com.eitan.couponsproject.data.UserLoginDetailsDataObject;
import com.eitan.couponsproject.exceptions.ApplicationException;
import com.eitan.couponsproject.logic.UserController;

@RestController
@RequestMapping("/users")
public class UserApi {

	@Autowired
	private UserController userController;

	@PostMapping
	@RequestMapping("/login")
	public LoginResponseDataObject login(@RequestBody UserLoginDetailsDataObject userLoginDetailsDataObject) throws ApplicationException{

		String userName = userLoginDetailsDataObject.getUserName();
		String password = userLoginDetailsDataObject.getPassword();
		
		LoginResponseDataObject loginResponseDataObject = userController.login(userName, password);

		return loginResponseDataObject;
	}

	@PostMapping
	public long createUser(@RequestBody User user) throws ApplicationException{
		return userController.createUser(user);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) throws ApplicationException{
		userController.updateUser(user);
	}

	@GetMapping
	@RequestMapping("/getUser/{userId}")
	public User getUserById(@PathVariable("userId") long userId) throws ApplicationException{
		return userController.getUserById(userId);
	}

	@DeleteMapping
	@RequestMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") long userId) throws ApplicationException{
		userController.deleteUser(userId);
	}

	@GetMapping
	public List<User> getAllUsers() throws ApplicationException{
		return userController.getAllUsers();
	}
}
