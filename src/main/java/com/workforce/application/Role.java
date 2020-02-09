package com.workforce.application;

public enum Role {
	ASSISTANT (1000),
	MANAGER (2000),
	BOSS (3000);

	private final double salary;

	Role(double salary) {
		this.salary = salary;
	}

	double salary() { return salary; }
	
	
}