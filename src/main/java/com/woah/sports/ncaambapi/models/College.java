package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "colleges", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class College {

    @Id
    @Column(name = "college_id", nullable = false)
    private int collegeId;

    @Basic
    @Column(name = "location", length = 255)
    private String location;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Team> collegeTeams;

}
