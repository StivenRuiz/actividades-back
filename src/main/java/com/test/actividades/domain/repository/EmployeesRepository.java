package com.test.actividades.domain.repository;

import java.util.List;

import com.test.actividades.domain.model.Employee;

public interface EmployeesRepository {
	
	List<Employee> obtenerEmpleados(); 

}
