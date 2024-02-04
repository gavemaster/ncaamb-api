package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "teams", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {


    @EmbeddedId
    TeamPK teamPK;

    @Basic
    @Column(name = "team_name", nullable = false, length = 255)
    private String teamName;

    @Basic
    @Column(name = "location", length = 255)
    private String location;


    @Basic
    @Column(name = "team_abbr", length = 255)
    private String teamAbbr;


    @Basic
    @Column(name = "events_link", length = 255)
    private String eventsLink;



    @Basic
    @Column(name = "conference_link", length = 255)
    private String conferenceLink;


    @Basic
    @Column(name = "record_link", length = 255)
    private String recordLink;


    @Basic
    @Column(name = "ats_link", length = 255)
    private String atsLink;

    @Basic
    @Column(name = "ranks_link", length = 255)
    private String ranksLink;

    @ManyToOne
    @JoinColumn(name = "conference", referencedColumnName = "conference_id")
    private Conference conference;

    @ManyToOne
    @JoinColumn(name = "team_college_id", referencedColumnName = "college_id", insertable = false, updatable = false)
    private College college;

    @OneToMany(mappedBy = "team")
    private List<EventRoster> eventRosters = new ArrayList<>();

    @OneToMany(mappedBy="homeTeam")
    private List<Event> homeGames = new ArrayList<>();

    @OneToMany(mappedBy="awayTeam")
    private List<Event> awayGames = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<PlayerBoxScore> playerBoxScores = new ArrayList<>();

}
