package com.woah.sports.ncaambapi.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venues", schema = "woahdoescollegebball")
@Getter
@Setter
@EqualsAndHashCode
public class Venue {

    @Id
    @Column(name = "venue_id", nullable = false)
    private int venueId;
    @Basic
    @Column(name = "name", length = 255)
    private String name;
    @Basic
    @Column(name = "venue_city", length = 255)
    private String venueCity;
    @Basic
    @Column(name = "capacity")
    private Integer capacity;
    @Basic
    @Column(name = "indoor", columnDefinition = "tinyint")
    private boolean indoor;
    @Basic
    @Column(name = "venue_state", length = 255)
    private String venueState;
    @Basic
    @Column(name = "venue_ref", length = 255)
    private String venueRef;
    @Basic
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @OneToMany(mappedBy = "venue")
    private List<Event> venueEvents = new ArrayList<>();

}
