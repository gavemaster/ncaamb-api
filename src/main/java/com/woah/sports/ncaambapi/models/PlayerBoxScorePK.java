package com.woah.sports.ncaambapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class PlayerBoxScorePK implements Serializable {
    @Column(name="player_stats_athlete_id")
    private Integer playerBoxScoreAthleteId;

    @Column(name="player_stats_event_id")
    private Integer getPlayerBoxScoreEventId;



}
