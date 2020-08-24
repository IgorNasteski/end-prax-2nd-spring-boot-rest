package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import rest.example.rest.model.Organizer;
import rest.example.rest.model.Venue;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AddEventRequest {
    //FIELDS
    @JsonProperty("created")
    private String created;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty
    private Organizer organizer;

    @JsonProperty
    private Venue venue;


    //CONSTRUCTOR
    public AddEventRequest() {
    }

    //BUILDER PATTERN
    public static class AddEventRequestBuilder{
        //fields
        private int id;
        private String created;
        private String name;
        private String description;
        private Organizer organizer;
        private Venue venue;

        //constructors
        public AddEventRequestBuilder(){}
        public static AddEventRequestBuilder anEventRequest(){
            return new AddEventRequestBuilder();
        }

        //with
        public AddEventRequestBuilder withCreated(String created){
            this.created = created;
            return this;
        }
        public AddEventRequestBuilder withName(String name){
            this.name = name;
            return this;
        }
        public AddEventRequestBuilder withDescription(String description){
            this.description = description;
            return this;
        }
        public AddEventRequestBuilder withOrganizer(Organizer organizer){
            this.organizer = organizer;
            return this;
        }
        public AddEventRequestBuilder withVenue(Venue venue){
            this.venue = venue;
            return this;
        }

        //constructor "build" of main class EventRequest
        public AddEventRequest build(){
            AddEventRequest addEventRequest = new AddEventRequest();
            addEventRequest.created = this.created;
            addEventRequest.name = this.name;
            addEventRequest.description = this.description;
            addEventRequest.organizer = this.organizer;
            addEventRequest.venue = this.venue;
            return addEventRequest;
        }

    }

    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddEventRequest that = (AddEventRequest) o;

        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (organizer != null ? !organizer.equals(that.organizer) : that.organizer != null) return false;
        if (venue != null ? !venue.equals(that.venue) : that.venue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = created != null ? created.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (organizer != null ? organizer.hashCode() : 0);
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        return result;
    }

    //SETTERS AND GETTERS
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
