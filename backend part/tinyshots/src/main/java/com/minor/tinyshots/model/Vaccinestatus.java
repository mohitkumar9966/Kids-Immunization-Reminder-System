package com.minor.tinyshots.model;

import jakarta.persistence.*;
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
public class Vaccinestatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Vaccid;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private Boolean vaccine1Status ;
    private Boolean vaccine2Status ;
    private Boolean vaccine3Status ;
    private Boolean vaccine4Status ;
    private Boolean vaccine5Status ;
    private Boolean vaccine6Status ;
    private Boolean vaccine7Status ;
    private Boolean vaccine8Status ;
    private Boolean vaccine9Status ;
    private Boolean vaccine10Status ;
    private Boolean vaccine11Status ;
    private Boolean vaccine12Status ;
    private Boolean vaccine13Status ;
    private Boolean vaccine14Status ;
    private Boolean vaccine15Status ;
    private Boolean vaccine16Status ;
    private Boolean vaccine17Status ;
    private Boolean vaccine18Status ;
    private Boolean vaccine19Status;
    private Boolean vaccine20Status;



}
