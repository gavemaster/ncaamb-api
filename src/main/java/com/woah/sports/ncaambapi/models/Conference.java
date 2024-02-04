package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "conferences", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class Conference {

    @Id
    @Column(name = "conference_id", nullable = false)
    private int conferenceId;
    @Basic
    @Column(name = "conference_name", nullable = false, length = 255)
    private String conferenceName;

    @OneToMany(mappedBy = "conference")
    private List<Team> teams = new ArrayList<>();

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConferenceDetails> conferenceDetailsList = new ArrayList<>();

}
