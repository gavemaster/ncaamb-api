package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "player_stats", schema = "woahdoescollegebball")
public class PlayerBoxScore {

    @EmbeddedId
    private PlayerBoxScorePK playerBoxScorePK;


    @Basic
    @Column(name = "player_stats_team_id")
    private Integer playerStatsTeamId;



    @Basic
    @Column(name = "player_stats_season")
    private Integer playerStatsSeason;



    @Basic
    @Column(name = "blks")
    private Integer blks;



    @Basic
    @Column(name = "dreb")
    private Integer dreb;



    @Basic
    @Column(name = "stls")
    private Integer stls;



    @Basic
    @Column(name = "points_off_turnovers")
    private Integer pointsOffTurnovers;



    @Basic
    @Column(name = "flagrant_fouls")
    private Integer flagrantFouls;


    @Basic
    @Column(name = "fouls")
    private Integer fouls;

    @Basic
    @Column(name = "ejections")
    private Integer ejections;

    @Basic
    @Column(name = "tech_fouls")
    private Integer techFouls;


    @Basic
    @Column(name = "tot_reb")
    private Integer totReb;


    @Basic
    @Column(name = "minutes")
    private Integer minutes;


    @Basic
    @Column(name = "fantasy_rating", precision = 0)
    private Double fantasyRating;



    @Basic
    @Column(name = "plus_minus")
    private Integer plusMinus;



    @Basic
    @Column(name = "ast_to_ratio", precision = 0)
    private Double astToRatio;



    @Basic
    @Column(name = "stl_foul_ratio", precision = 0)
    private Double stlFoulRatio;



    @Basic
    @Column(name = "blk_foul_ratio", precision = 0)
    private Double blkFoulRatio;


    @Basic
    @Column(name = "stl_to_ratio", precision = 0)
    private Double stlToRatio;


    @Basic
    @Column(name = "games_played")
    private Integer gamesPlayed;


    @Basic
    @Column(name = "games_started")
    private Integer gamesStarted;



    @Basic
    @Column(name = "double_double", columnDefinition = "tinyint")
    private boolean doubleDouble;



    @Basic
    @Column(name = "triple_double", columnDefinition = "tinyint")
    private boolean tripleDouble;


    @Basic
    @Column(name = "ast")
    private Integer ast;


    @Basic
    @Column(name = "fga")
    private Integer fga;



    @Basic
    @Column(name = "fgm")
    private Integer fgm;


    @Basic
    @Column(name = "fg_pct", precision = 0)
    private Double fgPct;


    @Basic
    @Column(name = "fta")
    private Integer fta;



    @Basic
    @Column(name = "ftm")
    private Integer ftm;


    @Basic
    @Column(name = "ft_pct", precision = 0)
    private Double ftPct;



    @Basic
    @Column(name = "oreb")
    private Integer oreb;


    @Basic
    @Column(name = "pts")
    private Integer pts;


    @Basic
    @Column(name = "turnovers")
    private Integer turnovers;


    @Basic
    @Column(name = "3fga")
    private Integer threeFga;


    @Basic
    @Column(name = "3fgm")
    private Integer threeFgm;


    @Basic
    @Column(name = "3fg_pct", precision = 0)
    private Double threeFgPct;

    @Basic
    @Column(name = "second_chance_pts")
    private Integer secondChancePts;


    @Basic
    @Column(name = "fast_break_pts")
    private Integer fastBreakPts;



    @Basic
    @Column(name = "oreb_pct", precision = 0)
    private Double orebPct;



    @Basic
    @Column(name = "2fga")
    private Integer twoFga;


    @Basic
    @Column(name = "2fgm")
    private Integer twoFgm;



    @Basic
    @Column(name = "2fg_pct", precision = 0)
    private Double twoFgPct;



    @Basic
    @Column(name = "shooting_eff", precision = 0)
    private Double shootingEff;



    @Basic
    @Column(name = "scoring_eff", precision = 0)
    private Double scoringEff;



    @Basic
    @Column(name = "last_updated")
    private Timestamp lastUpdated;


    @ManyToOne
    @JoinColumn(name="player_stats_athlete_id", referencedColumnName = "athlete_id", insertable = false, updatable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name="player_stats_event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    private Event event;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="player_stats_team_id", referencedColumnName = "team_college_id", insertable = false, updatable = false),
            @JoinColumn(name="player_stats_season", referencedColumnName = "team_season", insertable = false, updatable = false)
    })
    private Team team;


}
