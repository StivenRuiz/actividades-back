package com.test.actividades.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.actividades.domain.DTO.response.ResponseDTO;
import com.test.actividades.domain.model.Activity;
import com.test.actividades.domain.service.ActividadesService;
import com.test.actividades.domain.service.EmpleadosService;
import com.test.actividades.domain.service.utils.Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empleados")
@Api(value = "Controlador que contiene los métodos del API relacionados con los empleados")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Respuesta exitosa."),
		@ApiResponse(code = 400, message = "Petición incorrecta."),
		@ApiResponse(code = 404, message = "No se encontraron datos."),
		@ApiResponse(code = 500, message = "Error del servidor.") })
public class EmpleadoController {

	@Autowired
	EmpleadosService empleadosService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoController.class);
	
	@ApiOperation(value = "Consulta los empleados", notes = "Permite consultar los empleados")
	@GetMapping(value = "/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployees() {

		ResponseDTO response;
		try {
			response = empleadosService.obtenerEmpleados();
			
			if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
			
			if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
				
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (Exception ex) {
			response = Utils.errorResponse(LOGGER, ex);
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
		}
	}
}
