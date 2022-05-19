package com.test.actividades.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.test.actividades.domain.model.Activity;
import com.test.actividades.persistence.entity.Actividad;

@Mapper(componentModel = "spring", uses = IEmpleadoMapper.class)
public interface IActividadMapper {
	@Mappings({
        @Mapping(source = "idActividad", target = "idActivity"),
        @Mapping(source = "estado", target = "state"),
        @Mapping(source = "fechaEstimada", target = "estimatedDate"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "idEmpleado", target = "employeeId"),
	})
	Activity toActivity(Actividad actividad);
	List<Activity> toActivities(List<Actividad> actividades);
	
	@InheritInverseConfiguration
	Actividad toActividad(Activity activity);
	List<Actividad> toActividades(List<Activity> activity);
}
