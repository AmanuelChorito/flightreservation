package miu.cs544.project.flightreservation.service;


import miu.cs544.project.flightreservation.model.Role;
import miu.cs544.project.flightreservation.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRole(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

    User getLoggedInUser();

    User deleteUser(int id);
}
