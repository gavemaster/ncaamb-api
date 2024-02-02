package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "athletes", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class Athlete {

    @Id
    @Column(name = "athlete_id")
    private Integer athleteId;

    @Basic
    @Column(name = "first_name", length = 255)
    private String firstName;

    @Basic
    @Column(name = "last_name", length = 255)
    private String lastName;


    @Basic
    @Column(name = "full_name", length = 255)
    private String fullName;


    @Basic
    @Column(name = "birthplace", length = 255)
    private String birthplace;



    @Basic
    @Column(name = "athlete_ref", length = 255)
    private String athleteRef;


    @Basic
    @Column(name = "last_updated")
    private Timestamp lastUpdated;


    @Basic
    @Column(name = "headshot", length = 255)
    private String headshot;



    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<EventRoster> eventRosters = new ArrayList<>();

}
