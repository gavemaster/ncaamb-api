package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "event_details", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class EventDetails {

    @Id
    @Column(name = "details_event_id", nullable = false)
    private int detailsEventId;

    @Basic
    @Column(name = "odds_ref", length = 255)
    private String oddsRef;

    @Basic
    @Column(name = "neutral_site", columnDefinition = "tinyint")
    private boolean neutralSite;

    @Basic
    @Column(name = "division_game", columnDefinition = "tinyint")
    private boolean divisionGame;

    @Basic
    @Column(name = "conference_game", columnDefinition = "tinyint")
    private boolean conferenceGame;

    @Basic
    @Column(name = "home_team_stats_ref", length = 255)
    private String homeTeamStatsRef;

    @Basic
    @Column(name = "away_team_stats_ref", length = 255)
    private String awayTeamStatsRef;

    @Basic
    @Column(name = "home_team_roster_ref", length = 255)
    private String homeTeamRosterRef;

    @Basic
    @Column(name = "away_team_roster_ref", length = 255)
    private String awayTeamRosterRef;

    @Basic
    @Column(name = "event_details_ref", length = 255)
    private String eventDetailsRef;

    @Basic
    @Column(name = "event_ref", length = 255)
    private String eventRef;

    @Basic
    @Column(name = "status", length = 255)
    private String status;

    @Basic
    @Column(name = "home_team_rank", length = 255)
    private String homeTeamRank;

    @Basic
    @Column(name = "away_team_rank", length = 255)
    private String awayTeamRank;

    @Basic
    @Column(name = "home_team_win", columnDefinition = "tinyint")
    private boolean homeTeamWin;

    @Basic
    @Column(name = "away_team_win", columnDefinition = "tinyint")

    private boolean awayTeamWin;

    @Basic
    @Column(name = "home_team_record_ref", length = 255)
    private String homeTeamRecordRef;

    @Basic
    @Column(name = "away_team_record_ref", length = 255)
    private String awayTeamRecordRef;

    @Basic
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @OneToOne
    @JoinColumn(name = "details_event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    private Event event;

}
