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
public class EventRosterPK implements Serializable {
    @Column(name="roster_team_id")
    private Integer rosterTeamId;

    @Column(name="roster_event_id")
    private Integer rosterEventId;

    @Column(name="roster_athlete_id")
    private Integer rosterAthleteId;
}
