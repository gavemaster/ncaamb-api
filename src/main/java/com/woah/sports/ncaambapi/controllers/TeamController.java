package com.woah.sports.ncaambapi.controllers;


import com.woah.sports.ncaambapi.dtos.TeamInfo;
import com.woah.sports.ncaambapi.models.TeamPK;
import com.woah.sports.ncaambapi.services.TeamService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/woahapi/v1/sports/ncaamb/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);
    @GetMapping("/team-info/{season}/{id}")
    public ResponseEntity<TeamInfo> getTeamInfo(
            @PathVariable("season") int season,
            @PathVariable("id") int id) {
        try {
            TeamPK teamPK = TeamPK.builder()
                    .teamCollegeId(id)
                    .teamSeason(season)
                    .build();

            TeamInfo teamInfo = teamService.getTeamInfo(teamPK);
            return ResponseEntity.ok(teamInfo);
        } catch (NotFoundException e) {
            logger.warn("Team not found for season {} and id {}", season, id, e);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Unexpected error while fetching team info", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

