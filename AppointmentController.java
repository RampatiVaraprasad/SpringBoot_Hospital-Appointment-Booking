package com.example.demo.RestController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModelClass.Appointment;
import com.example.demo.ServiceClass.AppointmentService;

@RestController
@RequestMapping("/appointments")
@Validated
public class AppointmentController {

	private final AppointmentService appointmentService;
	
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	// Book a new appointment
	
	public Appointment bookAppointment(@Validated @RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(appointment);
	}
	// get all appointment
	
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	// get appointment by id
	@GetMapping("/{id}")
	public Appointment getAppointmentById(@PathVariable Integer id) {
		return appointmentService.getAppointmentById(id);
	}
	// Search appointments by doctor
	@GetMapping("/doctor/{doctorName}")
	public List<Appointment> getAppointmentsByDoctor(@PathVariable String doctorName){
		return appointmentService.getAppointmentsByDoctor(doctorName);
		
	}
	// Search appointments by date
	public List<Appointment> getAppointmentsByDate(@PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date){
		return appointmentService.getAppointmentsByDate(date);
	}
	// sort appointments by date
	public List<Appointment> getAppointmentsSortedByDate(){
		return appointmentService.getAppointmentsSortedByDate();
	}
	// Delete Appointment
	public String deleteAppointment(@PathVariable Integer id) {
		return appointmentService.deleteAppointment(id);
	}
}
