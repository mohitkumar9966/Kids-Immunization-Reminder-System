package com.minor.tinyshots.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String name;
    private String number;
    private String relation;
    private String gender;
    private String password;
    private String child_name;
    private LocalDate parent_dob;
    private LocalDate child_dob;
    private String bgp;
    private String h_condition;
    private Integer born_in_months;
    private String p_history;
    private LocalDate vaccine1DueDate;
    private LocalDate vaccine2DueDate;
    private LocalDate vaccine3DueDate;
    private LocalDate vaccine4DueDate;
    private LocalDate vaccine5DueDate;
    private LocalDate vaccine6DueDate;
    private LocalDate vaccine7DueDate;
    private LocalDate vaccine8DueDate;
    private LocalDate vaccine9DueDate;
    private LocalDate vaccine10DueDate;
    private LocalDate vaccine11DueDate;
    private LocalDate vaccine12DueDate;
    private LocalDate vaccine13DueDate;
    private LocalDate vaccine14DueDate;
    private LocalDate vaccine15DueDate;
    private LocalDate vaccine16DueDate;
    private LocalDate vaccine17DueDate;
    private LocalDate vaccine18DueDate;
    private LocalDate vaccine19DueDate;
    private LocalDate vaccine20DueDate;



}
