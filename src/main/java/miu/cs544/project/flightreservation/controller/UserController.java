package miu.cs544.project.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import miu.cs544.project.flightreservation.model.User;
import miu.cs544.project.flightreservation.service.UserService;
import miu.cs544.project.flightreservation.service.UserServiceImp;

@RestController
@Data
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> allCountry(){
		return userService.allUsers();
	}

	public User saveUser(User user) {
		return userService.saveUser(user);
	}
}
