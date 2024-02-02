package com.woah.sports.ncaambapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.woah.sports.ncaambapi.dtos.TeamInfo;
import com.woah.sports.ncaambapi.models.Team;
import com.woah.sports.ncaambapi.models.TeamPK;
import com.woah.sports.ncaambapi.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepo;
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);
    public TeamInfo getTeamInfo(TeamPK teamPK){
        try {
            logger.info("Getting team info for TeamPK: {}", teamPK);
            Team team = teamRepo.findTeamByTeamPK(teamPK);
            if (team == null) {
                logger.warn("Team not found for TeamPK: {}", teamPK);
                return TeamInfo.builder()
                        .season(teamPK.getTeamSeason())
                        .teamId(teamPK.getTeamCollegeId())
                        .teamName("TEAM NOT FOUND")
                        .teamLocation("ERROR")
                        .teamAbbr("ERROR")
                        .build();
            }
            logger.info("Team info retrieved successfully for TeamPK: {}", teamPK);
            return TeamInfo.builder()
                    .season(teamPK.getTeamSeason())
                    .teamId(teamPK.getTeamCollegeId())
                    .teamLocation(team.getLocation())
                    .teamName(team.getTeamName())
                    .teamAbbr(team.getTeamAbbr())
                    .build();
        } catch (Exception e) {
            logger.error("Error getting team info for TeamPK: {}", teamPK, e);
            throw e; // Rethrow the exception to be caught by the controller
        }
    }
}
