package com.woah.sports.ncaambapi.services;


import com.woah.sports.ncaambapi.dtos.EventInfo;
import com.woah.sports.ncaambapi.models.Event;
import com.woah.sports.ncaambapi.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventRepository eventRepo;

    public EventInfo getEventInfo(int id){
        Event event = eventRepo.findByEventId(id);
        if(event == null){
            return EventInfo.builder()
                    .eventName("INVALID EVENT ID")
                    .eventShortName("ERROR")
                    .build();
        }else{
            return EventInfo.builder()
                    .homeTeamId(event.getHomeTeamCollegeId())
                    .homeTeamName(event.getHomeTeam().getTeamName())
                    .awayTeamId(event.getAwayTeamCollegeId())
                    .awayTeamName(event.getAwayTeam().getTeamName())
                    .eventName(event.getEventName())
                    .eventShortName(event.getEventShortName())
                    .build();
        }
    }

    public List<EventInfo> getEventsByDate(Date date){
        List<EventInfo> eventInfos = new ArrayList<>();
        List<Event> events = eventRepo.findEventsByDate(date);
        for(Event e: events){
            EventInfo event = getEventInfo(e.getEventId());
            eventInfos.add(event);
        }

        return eventInfos;

    }


}
