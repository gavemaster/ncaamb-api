package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "conference_details", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class ConferenceDetails {

    @EmbeddedId
    private ConferenceDetailsPK conferenceDetailsPK;

    @Basic
    @Column(name = "conference_name", nullable = true, length = 255)
    private String conferenceName;


    @Basic
    @Column(name = "conference_short_name", nullable = true, length = 255)
    private String conferenceShortName;


    @Basic
    @Column(name = "conference_standings_ref", nullable = true, length = 255)
    private String conferenceStandingsRef;

    @Basic
    @Column(name = "conference_teams_ref", nullable = true, length = 255)
    private String conferenceTeamsRef;



    @Basic
    @Column(name = "last_updated", nullable = true)
    private Timestamp lastUpdated;


    @ManyToOne
    @MapsId("detailsConferenceId")
    @JoinColumn(name = "details_conference_id")
    private Conference conference;


}
