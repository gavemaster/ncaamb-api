package com.woah.sports.ncaambapi.dtos;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TeamYearHome {

    private int season;

    private int teamId;

    private String teamName;

    private int wins;

    private int losses;

    private int rank;



}
