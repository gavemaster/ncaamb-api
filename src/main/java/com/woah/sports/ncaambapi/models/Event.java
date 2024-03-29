package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events", schema = "woahdoescollegebball")
public class Event {

    @Id
    @Column(name = "event_id", nullable = false)
    private int eventId;
    @Basic
    @Column(name = "event_name", length = 255)
    private String eventName;
    @Basic
    @Column(name = "event_short_name", length = 255)
    private String eventShortName;

    @Temporal(TemporalType.DATE)
    @Column(name = "event_date")
    private Date eventDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_time")
    private Timestamp eventTime;

    @Basic
    @Column(name = "event_venue_id")
    private Integer eventVenueId;

    @Basic
    @Column(name = "home_team_college_id", nullable = false)
    private int homeTeamCollegeId;

    @Basic
    @Column(name = "away_team_college_id", nullable = false)
    private int awayTeamCollegeId;
    @Basic
    @Column(name = "home_team_score")
    private Integer homeTeamScore;
    @Basic
    @Column(name = "away_team_score")
    private Integer awayTeamScore;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated")
    private Timestamp lastUpdated;
    @Basic
    @Column(name = "event_season", nullable = false)
    private int eventSeason;
    @Basic
    @Column(name = "event_week")
    private Integer eventWeek;
    @Basic
    @Column(name = "event_season_type")
    private Integer eventSeasonType;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="home_team_college_id", referencedColumnName = "team_college_id", insertable = false, updatable = false),
            @JoinColumn(name="event_season", referencedColumnName = "team_season", insertable = false, updatable = false)
    })
    private Team homeTeam;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="away_team_college_id", referencedColumnName = "team_college_id", insertable = false, updatable = false),
            @JoinColumn(name="event_season", referencedColumnName = "team_season", insertable = false, updatable = false)
    })
    private Team awayTeam;


    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private EventDetails eventDetails;

    @ManyToOne
    @JoinColumn(name="event_venue_id", referencedColumnName = "venue_id", insertable = false, updatable = false)
    private Venue venue;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<PlayerBoxScore> playerBoxScores = new ArrayList<>();



}
