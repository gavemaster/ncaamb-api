package com.woah.sports.ncaambapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamPK implements Serializable {

    @Column(name="team_season", nullable = false)
    private Integer teamSeason;

    @Column(name="team_college_id", nullable = false)
    private Integer teamCollegeId;



}
