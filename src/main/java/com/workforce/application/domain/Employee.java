package com.workforce.application.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public
class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private Role role;
    private double salary;
	
	Employee() {}

	Employee(String name, Role role) {
		this.name = name;

		switch (role) { //switch (role.toString()) {
		case ASSISTANT:  //case "assistant":
			this.role= Role.ASSISTANT;
			break;
		case MANAGER:    //case "manager":
			this.role= Role.MANAGER;
			break;
		case BOSS:    //case "boss":
			this.role= Role.BOSS;
			break;
		}
		
		this.salary = this.role.salary();
	}

	

}
