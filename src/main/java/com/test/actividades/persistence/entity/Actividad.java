package com.test.actividades.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="Actividad", schema = "actividades")
public class Actividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdActividad", nullable = false)
	private Integer idActividad;
	
	@Column(name="Estado", nullable = false)
	private String estado;
	
	@Column(name="FechaEstimada", nullable = false)
	private LocalDateTime fechaEstimada;
	
	@Column(name="Nombre", nullable = false)
	private String nombre;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IdEmpleado", nullable = false)
	private Empleado idEmpleado;
}
