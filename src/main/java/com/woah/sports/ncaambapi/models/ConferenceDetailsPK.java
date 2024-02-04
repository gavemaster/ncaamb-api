package com.woah.sports.ncaambapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ConferenceDetailsPK implements Serializable {

    @Column(name="details_conference_id")
    private int detailsConferenceId;

    @Column(name="conference_season")
    private int conferenceSeason;
}
