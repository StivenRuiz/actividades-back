package com.test.actividades.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.actividades.domain.DTO.response.ResponseDTO;
import com.test.actividades.domain.model.Employee;
import com.test.actividades.domain.repository.EmployeesRepository;
import com.test.actividades.domain.service.utils.Utils;

@Service
public class EmpleadosService {

	@Autowired
	private EmployeesRepository employeesRepository;
	
	public ResponseDTO obtenerEmpleados() {
		ResponseDTO responseDTO;
		List<Employee> employees;
		
		try {
			employees = employeesRepository.obtenerEmpleados();
			
			if (!employees.isEmpty()) {
				responseDTO = Utils.updateResponse(true, Optional.of(employees), 
						HttpStatus.OK.value(), "Consulta Exitosa.");
			} else {
				responseDTO = Utils.updateResponse(false, Optional.empty(), 
						HttpStatus.NOT_FOUND.value(), "No se encontraron registros.");
			}
		} catch (Exception e) {
			responseDTO = Utils.updateResponse(false, Optional.empty(), 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
		return responseDTO;
	}
	
}
