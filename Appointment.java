package com.example.demo.ModelClass;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Appointment {
	
	private Integer appointmentId;
	
	@NotBlank(message = "patient name is required")
	private String patientName;
	
	@NotBlank(message = "Doctor name is required")
	private String doctorName;
	
	@NotBlank(message = "Disease field can not be empty")
	private String disease;
	
	@NotNull(message = "Appointment date is required")
	@FutureOrPresent(message = "Appointment date can not be in the past ")
	private LocalDate appointmentDate;

	public Appointment(Integer appointmentId, @NotBlank(message = "patient name is required") String patientName,
			@NotBlank(message = "Doctor name is required") String doctorName,
			@NotBlank(message = "Disease field can not be empty") String disease,
			@NotNull(message = "Appointment date is required") @FutureOrPresent(message = "Appointment date can not be in the past ") LocalDate appointmentDate) {
		super();
		this.appointmentId = appointmentId;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.disease = disease;
		this.appointmentDate = appointmentDate;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}
