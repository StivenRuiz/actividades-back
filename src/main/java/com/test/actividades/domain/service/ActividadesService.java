package com.test.actividades.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.actividades.domain.DTO.response.ResponseDTO;
import com.test.actividades.domain.model.Activity;
import com.test.actividades.domain.repository.ActivitiesRepository;
import com.test.actividades.domain.service.utils.Utils;

@Service
public class ActividadesService {

	@Autowired
	private ActivitiesRepository activitiesRepository;
	
	public ResponseDTO obtenerActividades() {
		ResponseDTO responseDTO;
		List<Activity> activities;
		
		try {
			activities = activitiesRepository.obtenerActividades();
			
			if (!activities.isEmpty()) {
				responseDTO = Utils.updateResponse(true, Optional.of(activities), 
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
	
	public ResponseDTO crearActividad(Activity activity) {
		ResponseDTO responseDTO;
		Activity activityR;
		try {
			activityR = activitiesRepository.crearActividad(activity);
			
			if (activityR != null) {
				responseDTO = Utils.updateResponse(true, Optional.of(activityR), 
						HttpStatus.OK.value(), "Actividad Creada.");
				
				if (activityR != null && activity.getIdActivity() != null) {
					responseDTO = Utils.updateResponse(true, Optional.of(activityR), 
							HttpStatus.OK.value(), "Actividad Actualizada.");
				}
				
			} else {
				responseDTO = Utils.updateResponse(false, Optional.empty(), 
						HttpStatus.BAD_REQUEST.value(), "No se guardo la actividad.");
			}
		} catch (Exception e) {
			responseDTO = Utils.updateResponse(false, Optional.empty(), 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
		return responseDTO;
	}
	
	public ResponseDTO eliminarActividad(Integer idActivity) {
		ResponseDTO responseDTO;
		try {
			activitiesRepository.eliminarActividad(idActivity);
			responseDTO = Utils.updateResponse(true, Optional.empty(),
					HttpStatus.OK.value(), "Actividad Eliminada.");
			
		} catch (Exception e) {
			responseDTO = Utils.updateResponse(false, Optional.empty(), 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
		return responseDTO;
	}
}
