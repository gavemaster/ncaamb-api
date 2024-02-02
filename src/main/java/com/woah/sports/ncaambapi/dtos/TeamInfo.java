package com.woah.sports.ncaambapi.dtos;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamInfo {
    private int teamId;
    private String teamName;
    private String teamLocation;
    private String teamAbbr;
    private int season;
}
