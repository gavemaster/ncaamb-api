package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "event_rosters", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class EventRoster {

    @EmbeddedId
    EventRosterPK eventRosterPK;

    @Basic
    @Column(name = "roster_season", nullable = false)
    private Integer rosterSeason;


    @Basic
    @Column(name = "did_not_play", columnDefinition = "tinyint")
    private boolean didNotPlay;

    @Basic
    @Column(name = "stats_ref", length = 255)
    private String statsRef;

    @Basic
    @Column(name = "starter", columnDefinition = "tinyint")
    private boolean starter;


    @Basic
    @Column(name = "ejected", columnDefinition = "tinyint")
    private boolean ejected;


    @Basic
    @Column(name = "athlete_ref", length = 255)
    private String athleteRef;

    @Basic
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @ManyToOne
    @JoinColumn(name = "roster_athlete_id", referencedColumnName = "athlete_id", insertable = false, updatable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "roster_season", referencedColumnName = "team_season", insertable = false, updatable = false),
            @JoinColumn(name = "roster_team_id", referencedColumnName = "team_college_id", insertable = false, updatable = false)
    })
    private Team team;





}
