package com.test.actividades.domain.repository;

import java.util.List;

import com.test.actividades.domain.model.Activity;

public interface ActivitiesRepository {
	
	List<Activity> obtenerActividades(); 
	
	Activity crearActividad(Activity activity);
	
	void eliminarActividad(Integer idActivity);
	
}
