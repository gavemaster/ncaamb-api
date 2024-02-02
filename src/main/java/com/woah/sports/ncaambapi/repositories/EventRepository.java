package com.woah.sports.ncaambapi.repositories;

import com.woah.sports.ncaambapi.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    Event findByEventId(int eventId);

    List<Event> findEventsByEventDateIs(Timestamp date);



}
