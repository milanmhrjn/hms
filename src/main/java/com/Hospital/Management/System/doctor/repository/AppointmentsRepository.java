package com.Hospital.Management.System.doctor.repository;

import com.Hospital.Management.System.doctor.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment,Long> {
}
