package com.aka.crud.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
	
	public User() {}

	public User(long id, String name, Date birthDay) {
		this.id = id;
		this.name = name;
		this.birthday = birthDay;
	}

	@Id
    @Getter
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Setter
    @Getter
    private String name;
    
	@Setter
    @Getter
    private Date birthday;

}
