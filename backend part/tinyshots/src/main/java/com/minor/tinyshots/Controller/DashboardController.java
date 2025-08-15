package com.minor.tinyshots.Controller;

import com.minor.tinyshots.model.User;
import com.minor.tinyshots.model.Vaccinestatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.minor.tinyshots.repo.*;
import com.minor.tinyshots.Service.impl.service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@CrossOrigin
@RestController
public class DashboardController {
    @Autowired
    private userrepo userrepo;
    @Autowired
    private Vaccrepo vaccrepo;
    @Autowired
    private service service;

    @ResponseBody
    @PostMapping("/dashboard/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable Long id,@RequestParam String columnName ) {
        try {
            System.out.println("got params");
            service.updateStatus(columnName,id);
            return ResponseEntity.ok("Status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status");
        }
    }





    @GetMapping("/dashboard/{id}")
    public ResponseEntity<Map<String, Object>> getUserAndVaccineStatus(@PathVariable Long id) {
        Map<String, Object> responseData = new HashMap<>();

        // Fetch user details
        Optional<User> userOptional = userrepo.findById(String.valueOf(id));
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            responseData.put("Vaccine1", user.getVaccine1DueDate());
            responseData.put("Vaccine2", user.getVaccine2DueDate());
            responseData.put("Vaccine3", user.getVaccine3DueDate());
            responseData.put("Vaccine4", user.getVaccine4DueDate());
            responseData.put("Vaccine5", user.getVaccine5DueDate());
            responseData.put("Vaccine6", user.getVaccine6DueDate());
            responseData.put("Vaccine7", user.getVaccine7DueDate());
            responseData.put("Vaccine8", user.getVaccine8DueDate());
            responseData.put("Vaccine9", user.getVaccine9DueDate());
            responseData.put("Vaccine10", user.getVaccine10DueDate());
            responseData.put("Vaccine11", user.getVaccine11DueDate());
            responseData.put("Vaccine12", user.getVaccine12DueDate());
            responseData.put("Vaccine13", user.getVaccine13DueDate());
            responseData.put("Vaccine14", user.getVaccine14DueDate());
            responseData.put("Vaccine15", user.getVaccine15DueDate());
            responseData.put("Vaccine16", user.getVaccine16DueDate());
            responseData.put("Vaccine17", user.getVaccine17DueDate());
            responseData.put("Vaccine18", user.getVaccine18DueDate());
            responseData.put("Vaccine19", user.getVaccine19DueDate());
            responseData.put("Vaccine20", user.getVaccine20DueDate());
        } else {
            responseData.put("error", "User not found");
        }

        Optional<Vaccinestatus> vaccineStatusOptional = vaccrepo.findByUser_Id(Long.valueOf(id));
        if (vaccineStatusOptional.isPresent()) {
            Vaccinestatus vaccineStatus = vaccineStatusOptional.get();
            responseData.put("Vaccine1Status", vaccineStatus.getVaccine1Status());
            responseData.put("Vaccine2Status", vaccineStatus.getVaccine2Status());
            responseData.put("Vaccine3Status", vaccineStatus.getVaccine3Status());
            responseData.put("Vaccine4Status", vaccineStatus.getVaccine4Status());
            responseData.put("Vaccine5Status", vaccineStatus.getVaccine5Status());
            responseData.put("Vaccine6Status", vaccineStatus.getVaccine6Status());
            responseData.put("Vaccine7Status", vaccineStatus.getVaccine7Status());
            responseData.put("Vaccine8Status", vaccineStatus.getVaccine8Status());
            responseData.put("Vaccine9Status", vaccineStatus.getVaccine9Status());
            responseData.put("Vaccine10Status", vaccineStatus.getVaccine10Status());
            responseData.put("Vaccine11Status", vaccineStatus.getVaccine11Status());
            responseData.put("Vaccine12Status", vaccineStatus.getVaccine12Status());
            responseData.put("Vaccine13Status", vaccineStatus.getVaccine13Status());
            responseData.put("Vaccine14Status", vaccineStatus.getVaccine14Status());
            responseData.put("Vaccine15Status", vaccineStatus.getVaccine15Status());
            responseData.put("Vaccine16Status", vaccineStatus.getVaccine16Status());
            responseData.put("Vaccine17Status", vaccineStatus.getVaccine17Status());
            responseData.put("Vaccine18Status", vaccineStatus.getVaccine18Status());
            responseData.put("Vaccine19Status", vaccineStatus.getVaccine19Status());
            responseData.put("Vaccine20Status", vaccineStatus.getVaccine20Status());
        } else {
            responseData.put("error", "Vaccine status not found");
        }

        return ResponseEntity.ok(responseData);
    }
}
