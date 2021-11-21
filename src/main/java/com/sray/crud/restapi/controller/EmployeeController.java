package com.sray.crud.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sray.crud.restapi.response.ResponseHandler;
import com.sray.crud.restapi.service.EmployeeService;
import com.sray.crud.restapi.entity.EmployeeEntity;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public ResponseEntity<Object> home() {
		try {
			return ResponseHandler.getResponse("Welcome to employee management system", HttpStatus.OK, null);
		} catch(Exception e) {
			return ResponseHandler.getResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Object> getEmployees() {
		try {
			List<EmployeeEntity> employees = this.employeeService.getEmployees();
			return ResponseHandler.getResponse("Successfully retrieved data", HttpStatus.OK, employees);
		} catch(Exception e) {
			return ResponseHandler.getResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable int id) {
		try {
			EmployeeEntity employee = this.employeeService.getEmployeeById(id);
			if(employee != null) {
				return ResponseHandler.getResponse("Successfully retrieved employee with given id", HttpStatus.OK, employee);
			} else {
				return ResponseHandler.getResponse("No such employee found", HttpStatus.NOT_FOUND, null);
			}
		} catch (Exception e) {
			return ResponseHandler.getResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployeeById(@PathVariable int id, @RequestBody EmployeeEntity newEmployee){
		try {
			EmployeeEntity employee = this.employeeService.updateEmployeeById(id,newEmployee);
			if(employee != null) {
				return ResponseHandler.getResponse("Update employee successfully", HttpStatus.OK, employee);
			} else {
				return ResponseHandler.getResponse("No such employee found", HttpStatus.NOT_FOUND, null);
			}
		} catch (Exception e) {
			return ResponseHandler.getResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeEntity newEmployee){
		try {
			this.employeeService.addEmployee(newEmployee);
			return ResponseHandler.getResponse("Employee added successfully", HttpStatus.OK, newEmployee);
		} catch (Exception e) {
			return ResponseHandler.getResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable int id) {
		try {
			boolean flag = this.employeeService.deleteEmployeeById(id);
			if(flag == true) {
				return ResponseHandler.getResponse("Employee deleted successfully", HttpStatus.OK, null);
			} else {
				return ResponseHandler.getResponse("No such employee exist", HttpStatus.NO_CONTENT, null);
			}
		} catch (Exception e) {
			return ResponseHandler.getResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
		}
	}
}

