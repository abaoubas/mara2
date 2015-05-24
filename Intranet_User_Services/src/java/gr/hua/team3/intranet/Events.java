/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3.intranet;

import java.util.Date;
import java.util.List;

/**
 *
 * @author abaoubas
 */
public class Events {

    
    private int event_id;
    private String event_location;
    private String event_producer;
    private Date event_from_date;
    private Date event_to_date;
    private List<Artist> Artists;
    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public String getEvent_producer() {
        return event_producer;
    }

    public void setEvent_producer(String event_producer) {
        this.event_producer = event_producer;
    }

    public Date getEvent_from_date() {
        return event_from_date;
    }

    public void setEvent_from_date(Date event_from_date) {
        this.event_from_date = event_from_date;
    }

    public Date getEvent_to_date() {
        return event_to_date;
    }

    public void setEvent_to_date(Date event_to_date) {
        this.event_to_date = event_to_date;
    }

    public List<Artist> getArtists() {
        return Artists;
    }

    public void setArtists(List<Artist> Artists) {
        this.Artists = Artists;
    }
}
