package com.test.actividades.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.actividades.domain.model.Activity;
import com.test.actividades.domain.repository.ActivitiesRepository;
import com.test.actividades.persistence.CRUD.IActividadCRUDRepository;
import com.test.actividades.persistence.mapper.IActividadMapper;

@Repository
public class ActividadesRepository implements ActivitiesRepository{

	@Autowired
	private IActividadMapper actividadMapper;
	
	@Autowired
	private IActividadCRUDRepository actividadCRUDRepository;
	
	@Override
	public List<Activity> obtenerActividades() {
		return actividadMapper.toActivities(actividadCRUDRepository.findAll());
	}

	@Override
	public Activity crearActividad(Activity activity) {
		return actividadMapper.toActivity(actividadCRUDRepository
				.save(actividadMapper
						.toActividad(activity)));
	}

	@Override
	public void eliminarActividad(Integer idActivity) {
		actividadCRUDRepository.deleteById(idActivity);
		return;
	}
	
}
