package miu.cs544.project.flightreservation.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Role roles;
    
	public User(String userName, String password, boolean active, Role roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}


    
}