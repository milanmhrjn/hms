package com.Hospital.Management.System.doctor.repository;

import com.Hospital.Management.System.doctor.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
