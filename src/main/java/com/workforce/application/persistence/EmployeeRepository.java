package com.workforce.application.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workforce.application.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
