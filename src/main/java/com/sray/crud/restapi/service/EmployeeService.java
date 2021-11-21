package com.sray.crud.restapi.service;

import java.util.List;

import com.sray.crud.restapi.entity.EmployeeEntity;

public interface EmployeeService {
	public List<EmployeeEntity> getEmployees();
	public EmployeeEntity getEmployeeById(int id);
	public EmployeeEntity updateEmployeeById(int id, EmployeeEntity params);
	public void addEmployee(EmployeeEntity params);
	public boolean deleteEmployeeById(int id);
}
