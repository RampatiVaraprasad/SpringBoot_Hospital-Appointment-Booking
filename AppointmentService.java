
package com.example.demo.ServiceClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.CustomException.AppointmentNotFoundException;
import com.example.demo.ModelClass.Appointment;

@Service
public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();
    private int nextId = 1;

    // 1. Book appointment
    public Appointment bookAppointment(Appointment appointment) {
        appointment.setAppointmentId(nextId++);
        appointments.add(appointment);
        return appointment;
    }

    // 2. Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointments.stream().toList();
    }

    // 3. Get appointment by ID
    public Appointment getAppointmentById(Integer id) {
        return appointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AppointmentNotFoundException(
                        "Appointment not found with id: " + id));
    }

    // 4. Search appointments by doctor name
    public List<Appointment> getAppointmentsByDoctor(String doctorName) {
        return appointments.stream()
                .filter(a -> a.getDoctorName().equalsIgnoreCase(doctorName))
                .toList();
    }

    // 5. Get appointments on a particular date
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointments.stream()
                .filter(a -> a.getAppointmentDate().equals(date))
                .toList();
    }

    // 6. Sort appointments by date

public List<Appointment> getAppointmentsSortedByDate() {
    return appointments.stream()
            .sorted(Comparator.comparing(
                    Appointment::getAppointmentDate))
            .toList();
}


    // 7. Delete appointment
    public String deleteAppointment(Integer id) {
        boolean removed = appointments.removeIf(
                a -> a.getAppointmentId().equals(id));

        if (!removed) {
            throw new AppointmentNotFoundException(
                    "Appointment not found with id: " + id);
        }

        return "Appointment deleted successfully";
    }
}
