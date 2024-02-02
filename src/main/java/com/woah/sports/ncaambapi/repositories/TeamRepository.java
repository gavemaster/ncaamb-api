package com.woah.sports.ncaambapi.repositories;

import com.woah.sports.ncaambapi.models.College;
import com.woah.sports.ncaambapi.models.Team;
import com.woah.sports.ncaambapi.models.TeamPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends CrudRepository<Team, TeamPK> {
    Team findTeamByTeamPK(TeamPK teamPK);

    List<Team> findTeamsByCollege(College college);

    List<Team> findTeamsByTeamNameOrTeamAbbr(String name, String abbr);



}
