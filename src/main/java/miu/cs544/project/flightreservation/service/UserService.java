package miu.cs544.project.flightreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import miu.cs544.project.flightreservation.model.User;
import miu.cs544.project.flightreservation.repository.UserRepository;


public interface UserService {

	
	
	public List<User> allUsers();
	
	public User saveUser(User user);
	
	public User getUserById(int id);
}
