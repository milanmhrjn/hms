package com.Hospital.Management.System.doctor.controller;

import com.Hospital.Management.System.doctor.entity.Appointment;
import com.Hospital.Management.System.doctor.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins="http://localhost:4200")
public class AppointmentController {
    @Autowired
    private AppointmentsRepository appointmentsRepository;
    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody  Appointment appointment){
        return appointmentsRepository.save(appointment);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return appointmentsRepository.findAll();
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
      Appointment appointment= appointmentsRepository.findById(id).
              orElseThrow(()->new AttributeNotFoundException("Appointment not found with id " + id));
      appointmentsRepository.delete(appointment);
      Map<String,Boolean> response = new HashMap<String, Boolean>();
      response.put("Deleted",Boolean.TRUE);
      return ResponseEntity.ok(response);
    }


}
