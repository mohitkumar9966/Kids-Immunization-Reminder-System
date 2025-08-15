package com.minor.tinyshots.Controller;
import com.minor.tinyshots.Service.impl.VaccineReminderScheduler;
import com.minor.tinyshots.model.Loginuser;
import com.minor.tinyshots.model.Vaccinestatus;
import com.minor.tinyshots.repo.Vaccrepo;
import com.minor.tinyshots.repo.userrepo;
import com.minor.tinyshots.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.minor.tinyshots.Service.impl.service;

import java.time.LocalDate;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private userrepo userrepo;
    @Autowired
    private Vaccrepo vaccrepo;
    @Autowired
    private service service;
    @Autowired
    private VaccineReminderScheduler vaccineReminderScheduler;


    @PostMapping("/authentication/sign-up")
    User newUser(@RequestBody User newUser)
    {
        LocalDate birthDate = newUser.getChild_dob();

        // Then, calculate the vaccine due dates based on the users birth date
        if (birthDate != null) {
            service.calculateVaccineDueDates(newUser);
        }
        newUser= userrepo.save(newUser);

        Vaccinestatus vaccinestatus= new Vaccinestatus();
//        vaccinestatus.setId(newUser.getId());
        vaccinestatus.setUser(newUser); // Setting the user in vaccinestatus



        vaccrepo.save(vaccinestatus);



        return newUser;


    }
    @PostMapping("/authentication/sign-in")
    public ResponseEntity<Long> login(@RequestBody Loginuser loginUser) {
        String email = Loginuser.getEmail();
        String password = Loginuser.getPassword();
        Long Id = service.validateLoginAndGetId(email, password);

        if (Id != null) {
            return ResponseEntity.ok(Id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/trigger-reminders")
    public ResponseEntity<String> triggerReminders() {
        vaccineReminderScheduler.processReminders();
        return ResponseEntity.ok("Vaccine reminders triggered successfully");
    }



}
