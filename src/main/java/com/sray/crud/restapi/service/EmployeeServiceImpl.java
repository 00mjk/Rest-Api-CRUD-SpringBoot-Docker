package com.sray.crud.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sray.crud.restapi.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<EmployeeEntity> employees = new ArrayList<>();
	
	public EmployeeServiceImpl() {
		employees.add(new EmployeeEntity(1, "A"));
		employees.add(new EmployeeEntity(2, "B"));
		employees.add(new EmployeeEntity(3, "C"));
	}
	
	@Override
	public List<EmployeeEntity> getEmployees() {
		return employees;
	}
	
	@Override
	public EmployeeEntity getEmployeeById(int givenId) {
		for(EmployeeEntity temp:employees) {
			if(temp.getId() == givenId) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public EmployeeEntity updateEmployeeById(int id, EmployeeEntity newEmployee) {
		for(EmployeeEntity temp:employees) {
			if(temp.getId() == id) {
				temp.setId(newEmployee.getId());
				temp.setName(newEmployee.getName());
				return newEmployee;
			}
		}
		return null;
	}

	@Override
	public void addEmployee(EmployeeEntity params) {
		employees.add(params);
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		for(EmployeeEntity temp:employees) {
			if(temp.getId() == id) {
				employees.remove(temp);
				return true;
			}
		}
		return false;
	}
}

