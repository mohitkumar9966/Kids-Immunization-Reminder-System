package com.minor.tinyshots.Controller;
import com.minor.tinyshots.model.User;
import com.minor.tinyshots.model.Vaccinestatus;
import com.minor.tinyshots.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@CrossOrigin
@RestController
public class TableController {

    @Autowired
    private userrepo userrepo;
    @Autowired
    private Vaccrepo vaccrepo;

    @GetMapping("/tables/{id}")
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
            responseData.put("vaccine1Status", vaccineStatus.getVaccine1Status());
            responseData.put("vaccine2Status", vaccineStatus.getVaccine2Status());
            responseData.put("vaccine3Status", vaccineStatus.getVaccine3Status());
            responseData.put("vaccine4Status", vaccineStatus.getVaccine4Status());
            responseData.put("vaccine5Status", vaccineStatus.getVaccine5Status());
            responseData.put("vaccine6Status", vaccineStatus.getVaccine6Status());
            responseData.put("vaccine7Status", vaccineStatus.getVaccine7Status());
            responseData.put("vaccine8Status", vaccineStatus.getVaccine8Status());
            responseData.put("vaccine9Status", vaccineStatus.getVaccine9Status());
            responseData.put("vaccine10Status", vaccineStatus.getVaccine10Status());
            responseData.put("vaccine11Status", vaccineStatus.getVaccine11Status());
            responseData.put("vaccine12Status", vaccineStatus.getVaccine12Status());
            responseData.put("vaccine13Status", vaccineStatus.getVaccine13Status());
            responseData.put("vaccine14Status", vaccineStatus.getVaccine14Status());
            responseData.put("vaccine15Status", vaccineStatus.getVaccine15Status());
            responseData.put("vaccine16Status", vaccineStatus.getVaccine16Status());
            responseData.put("vaccine17Status", vaccineStatus.getVaccine17Status());
            responseData.put("vaccine18Status", vaccineStatus.getVaccine18Status());
            responseData.put("vaccine19Status", vaccineStatus.getVaccine19Status());
            responseData.put("vaccine20Status", vaccineStatus.getVaccine20Status());
        } else {
            responseData.put("error", "Vaccine status not found");
        }

        return ResponseEntity.ok(responseData);
    }
}
