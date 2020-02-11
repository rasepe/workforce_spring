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

		switch (role.toString()) {
		case "assistant":
			this.role= Role.ASSISTANT;
			break;
		case "manager":
			this.role= Role.MANAGER;
			break;
		case "boss":
			this.role= Role.BOSS;
			break;
		}
		
		this.salary = this.role.salary();
	}

	

}
