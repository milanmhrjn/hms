package com.Hospital.Management.System.doctor.controller;

import com.Hospital.Management.System.doctor.entity.Medicine;
import com.Hospital.Management.System.doctor.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;
    @PostMapping("/medicines")
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine){
        Medicine medicines = medicineRepository.save(medicine);
        return new ResponseEntity<>(medicines,HttpStatus.CREATED);
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Object> getMedicineById(@PathVariable long id) {

        Optional<Medicine> medicine = medicineRepository.findById(id);
        if(medicine.isPresent()){
            return  new ResponseEntity<>(medicine.get(),HttpStatus.OK);
        }
        else{
          String   message = "Medicine Not Found id with:"+id;
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine =  medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found id with: "+id));
        medicine.setDrugName(medicineDetails.getDrugName());
        medicine.setStock(medicineDetails.getStock());
        medicineRepository.save(medicine);
        return ResponseEntity.ok(medicine);
    }
    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine =  medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found id with: "+id));
        medicineRepository.delete(medicine);
        Map<String,Boolean> response = new HashMap<String,Boolean>();
        response.put("Delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
