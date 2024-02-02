package com.woah.sports.ncaambapi.dtos;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventInfo {

    String homeTeamName;
    int homeTeamId;
    String awayTeamName;
    int awayTeamId;
    String eventName;
    String eventShortName;

}
