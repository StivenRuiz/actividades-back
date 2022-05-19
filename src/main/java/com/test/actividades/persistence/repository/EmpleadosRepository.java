package com.test.actividades.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.actividades.domain.model.Employee;
import com.test.actividades.domain.repository.EmployeesRepository;
import com.test.actividades.persistence.CRUD.IEmpleadoCRUDRepository;
import com.test.actividades.persistence.mapper.IEmpleadoMapper;

@Repository
public class EmpleadosRepository implements EmployeesRepository{

	@Autowired
	private IEmpleadoMapper empleadoMapper;
	
	@Autowired
	private IEmpleadoCRUDRepository empleadoCRUDRepository;
	
	@Override
	public List<Employee> obtenerEmpleados() {
		return empleadoMapper.toEmployees(empleadoCRUDRepository.findAll());
	}
	
}
