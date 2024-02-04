package com.woah.sports.ncaambapi.repositories;

import com.woah.sports.ncaambapi.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    Event findByEventId(int eventId);

    @Query("SELECT e FROM Event e WHERE e.eventDate = :date")
    List<Event> findEventsByDate(@Param("date") Date date);



}
