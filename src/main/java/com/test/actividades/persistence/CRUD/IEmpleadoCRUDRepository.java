package com.test.actividades.persistence.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.actividades.persistence.entity.Empleado;

public interface IEmpleadoCRUDRepository extends JpaRepository<Empleado, Integer>{
}
