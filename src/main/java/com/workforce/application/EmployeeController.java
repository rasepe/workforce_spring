package com.workforce.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

	private final EmployeeRepository repository;
	

	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@CrossOrigin(origins = "http://localhost")
	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "http://localhost")
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {   //(@RequestBody Employee newEmployee) 
		newEmployee.setSalary(newEmployee.getRole().salary());
		return repository.save(newEmployee);
	}

	// Single item
	@CrossOrigin(origins = "http://localhost")
	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	
	
	// Filter by role
	@CrossOrigin(origins = "http://localhost")
	@GetMapping("/employees/role/{role}")
	List<Employee> role(@PathVariable String role) {
		//List<String> cars = new List<String>();
		List<Employee> employeeList = repository.findAll();
		List<Employee> employeeListWithRole = new ArrayList<Employee>();
		//Iterable<Long> ids;
		for (long i=0; i<repository.count(); i++) {
			if (employeeList.get((int)i).getRole().name().equalsIgnoreCase(role)) {
				employeeListWithRole.add(employeeList.get((int)i));
			
			}
		}
		List<Long> listIds = new ArrayList<Long>();
		for (int i=0; i<employeeListWithRole.size(); i++) {
			listIds.add(employeeListWithRole.get(i).getId());
		}
			  
		return repository.findAllById(listIds);
				
	}
	

	
	@CrossOrigin(origins = "http://localhost")
	  @PutMapping("/employees/{id}")
	  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(employee -> {
	        employee.setName(newEmployee.getName());
	        employee.setRole(newEmployee.getRole());
	        employee.setSalary(employee.getRole().salary());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return repository.save(newEmployee);
	      });
	  }

	@CrossOrigin(origins = "http://localhost")
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
