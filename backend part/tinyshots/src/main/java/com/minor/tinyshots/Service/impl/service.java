package com.minor.tinyshots.Service.impl;

import com.minor.tinyshots.model.User;
import com.minor.tinyshots.model.Vaccinestatus;
import com.minor.tinyshots.repo.Vaccrepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.minor.tinyshots.repo.userrepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class service {

    @Autowired
    private userrepo userrepo;
    @Autowired
    private Vaccrepo vaccrepo;

    public Long validateLoginAndGetId(String email,String password) {
        User user1 = userrepo.findByEmailAndPassword(email, password);

        if (user1 != null) {
            return user1.getId();
        } else {
            return null;
        }
    }

    public ResponseEntity<String> updateStatus(String columnName, Long id) {
        Optional<Vaccinestatus> optionalVaccine = vaccrepo.findByUser_Id(id);
        if (optionalVaccine.isPresent()) {
            Vaccinestatus vaccinestatus = optionalVaccine.get();


        // Set the status based on the column name
        switch (columnName) {
            case "Vaccine1":
                vaccinestatus.setVaccine1Status(true);
                break;
            case "Vaccine2":
                vaccinestatus.setVaccine2Status(true);
                break;
            case "Vaccine3":
                vaccinestatus.setVaccine3Status(true);
                break;
            case "Vaccine4":
                vaccinestatus.setVaccine4Status(true);
                break;
            case "Vaccine5":
                vaccinestatus.setVaccine5Status(true);
                break;
            case "Vaccine6":
                vaccinestatus.setVaccine6Status(true);
                break;
            case "Vaccine7":
                vaccinestatus.setVaccine7Status(true);
                break;
            case "Vaccine8":
                vaccinestatus.setVaccine8Status(true);
                break;
            case "Vaccine9":
                vaccinestatus.setVaccine9Status(true);
                break;
            case "Vaccine10":
                vaccinestatus.setVaccine10Status(true);
                break;
            case "Vaccine11":
                vaccinestatus.setVaccine11Status(true);
                break;
            case "Vaccine12":
                vaccinestatus.setVaccine12Status(true);
                break;
            case "Vaccine13":
                vaccinestatus.setVaccine13Status(true);
                break;
            case "Vaccine14":
                vaccinestatus.setVaccine14Status(true);
                break;
            case "Vaccine15":
                vaccinestatus.setVaccine15Status(true);
                break;
            case "Vaccine16":
                vaccinestatus.setVaccine16Status(true);
                break;
            case "Vaccine17":
                vaccinestatus.setVaccine17Status(true);
                break;
            case "Vaccine18":
                vaccinestatus.setVaccine18Status(true);
                break;
            case "Vaccine19":
                vaccinestatus.setVaccine19Status(true);
                break;
            case "Vaccine20":
                vaccinestatus.setVaccine20Status(true);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid column name: " + columnName);

        }
            vaccrepo.save(vaccinestatus);
            return ResponseEntity.ok("Status updated successfully");

        } else {
                return ResponseEntity.notFound().build();
            }


    }


    public void calculateVaccineDueDates(User user) {
        LocalDate birthDate = user.getChild_dob();
        if (birthDate != null) {
            user.setVaccine1DueDate(birthDate.plusDays(0));
            user.setVaccine2DueDate(user.getVaccine1DueDate().plusDays(15));
            user.setVaccine3DueDate(user.getVaccine2DueDate().plusDays(20));
            user.setVaccine4DueDate(user.getVaccine3DueDate().plusDays(15));
            user.setVaccine5DueDate(user.getVaccine4DueDate().plusDays(20));
            user.setVaccine6DueDate(user.getVaccine5DueDate().plusDays(15));
            user.setVaccine7DueDate(user.getVaccine6DueDate().plusDays(20));
            user.setVaccine8DueDate(user.getVaccine7DueDate().plusDays(15));
            user.setVaccine9DueDate(user.getVaccine8DueDate().plusDays(20));
            user.setVaccine10DueDate(user.getVaccine9DueDate().plusDays(20));
            user.setVaccine11DueDate(user.getVaccine10DueDate().plusDays(15));
            user.setVaccine12DueDate(user.getVaccine11DueDate().plusDays(20));
            user.setVaccine13DueDate(user.getVaccine12DueDate().plusDays(15));
            user.setVaccine14DueDate(user.getVaccine13DueDate().plusDays(20));
            user.setVaccine15DueDate(user.getVaccine14DueDate().plusDays(25));
            user.setVaccine16DueDate(user.getVaccine15DueDate().plusDays(30));
            user.setVaccine17DueDate(user.getVaccine16DueDate().plusDays(45));
            user.setVaccine18DueDate(user.getVaccine17DueDate().plusDays(20));
            user.setVaccine19DueDate(user.getVaccine18DueDate().plusDays(20));
            user.setVaccine20DueDate(user.getVaccine19DueDate().plusDays(30));

        }
    }
}
