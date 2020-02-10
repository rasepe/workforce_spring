package com.workforce.application;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private Role role;
    private double salary;
	
	Employee() {}

	Employee(String name, String role) {
		this.name = name;

		switch (role) {
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
