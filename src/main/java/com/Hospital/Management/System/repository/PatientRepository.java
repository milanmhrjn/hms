package com.Hospital.Management.System.repository;

import com.Hospital.Management.System.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}

/*we create repository and extends jpa because we need to store the data in the database which need some methods
 and it provides those methods
 */