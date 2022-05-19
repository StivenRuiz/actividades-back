package com.test.actividades.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.test.actividades.domain.model.Employee;
import com.test.actividades.persistence.entity.Empleado;

@Mapper(componentModel = "spring")
public interface IEmpleadoMapper {
	@Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name"),
	})
	Employee toEmployee(Empleado empleado);
	List<Employee> toEmployees(List<Empleado> empleados);
	
	@InheritInverseConfiguration
	Empleado toEmpleado(Employee employee);
	List<Empleado> toEmpleados(List<Employee> employees);
}
