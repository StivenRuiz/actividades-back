package com.test.actividades.persistence.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.actividades.persistence.entity.Actividad;

public interface IActividadCRUDRepository extends JpaRepository<Actividad, Integer>{
}
