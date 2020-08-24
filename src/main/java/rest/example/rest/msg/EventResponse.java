package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import rest.example.rest.model.Organizer;
import rest.example.rest.model.Venue;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)//if some "null" value comes via request
@Generated("com.robohorse.robopojogenerator")
public class EventResponse {
    //fields
    @JsonProperty
    private String name;

    @JsonProperty
    private Organizer organizer;

    @JsonProperty
    private Venue venue;

    //contructor
    public EventResponse(){}


    //BUILDER PATTERN
    public static class EventResponseBuilder{
        //fields
        private String name;
        private Organizer organizer;
        private Venue venue;

        //contructor
        public EventResponseBuilder(){}
        public static EventResponseBuilder anEventResponse(){
            return new EventResponseBuilder();
        }

        //with
        public EventResponseBuilder withName(String name){
            this.name = name;
            return this;
        }
        public EventResponseBuilder withOrganizer(Organizer organizer){
            this.organizer = organizer;
            return this;
        }
        public EventResponseBuilder withVenue(Venue venue){
            this.venue = venue;
            return this;
        }

        //constructor "build" of main class EventResponse
        public EventResponse build(){
            EventResponse eventResponse = new EventResponse();
                eventResponse.name = this.name;
                eventResponse.organizer = this.organizer;
                eventResponse.venue = this.venue;
            return eventResponse;
        }

    }


    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventResponse that = (EventResponse) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (organizer != null ? !organizer.equals(that.organizer) : that.organizer != null) return false;
        return venue != null ? venue.equals(that.venue) : that.venue == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (organizer != null ? organizer.hashCode() : 0);
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        return result;
    }

    //setters and getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Organizer getOrganizer() {
        return organizer;
    }
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
    public Venue getVenue() {
        return venue;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
