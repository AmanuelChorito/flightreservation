package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.User;
import miu.cs544.project.flightreservation.repository.UserRepository;

@Service
@Data
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> allUsers(){
		return repository.findAll();
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}
}
