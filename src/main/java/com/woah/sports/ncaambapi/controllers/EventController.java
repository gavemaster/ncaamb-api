package com.woah.sports.ncaambapi.controllers;

import com.woah.sports.ncaambapi.dtos.EventInfo;
import com.woah.sports.ncaambapi.services.EventService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping("/woahapi/v1/sports/ncaamb/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event-info/{id}")
    public ResponseEntity<EventInfo> getEventInfo(
            @PathVariable("id") int id) {
        try {
            EventInfo eventInfo = eventService.getEventInfo(id);
            return ResponseEntity.ok(eventInfo);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/today")
    public ResponseEntity<List<EventInfo>> getTodayEvents(){
        try{
            // Get the current time in milliseconds
            long currentTimeMillis = System.currentTimeMillis();
            // Create a java.util.Date object with the current time
            Date currentDate = new Date(currentTimeMillis);
            // Convert the java.util.Date to java.sql.Timestamp
            Timestamp currentTimestamp = new Timestamp(currentDate.getTime());


            List<EventInfo> todayEvents = eventService.getEventsByDate(currentTimestamp);


            return ResponseEntity.ok(todayEvents);

        }catch(NotFoundException e){
            return ResponseEntity.notFound().build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
