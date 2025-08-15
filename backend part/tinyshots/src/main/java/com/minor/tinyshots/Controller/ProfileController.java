package com.minor.tinyshots.Controller;

import com.minor.tinyshots.model.User;
import com.minor.tinyshots.repo.userrepo;
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
public class ProfileController {

    @Autowired
    private userrepo userrepo;

    @GetMapping("/profile/{id}")
    public ResponseEntity<Map<String, Object>> getUserInfo(@PathVariable Long id) {
        Map<String, Object> responseData = new HashMap<>();
        Optional<User> userOptional = userrepo.findById(String.valueOf(id));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            responseData.put("Id", user.getId());
            responseData.put("Name",user.getName());
            responseData.put("Email",user.getEmail());
            responseData.put("Number",user.getNumber());
            responseData.put("Relation",user.getRelation());
            responseData.put("Gender",user.getGender());
            responseData.put("Child_Name",user.getChild_name());
            responseData.put("Parent_Dob",user.getParent_dob());
            responseData.put("Child_Dob",user.getChild_dob());
            responseData.put("Bloodgroup",user.getBgp());
            responseData.put("Health_Condition",user.getH_condition());
            responseData.put("Born_in_months",user.getBorn_in_months());
            responseData.put("Previous_History",user.getP_history());


        } else {
            responseData.put("error", "User not found");

        }

        return ResponseEntity.ok(responseData);
    }

}
