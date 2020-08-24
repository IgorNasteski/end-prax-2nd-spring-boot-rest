package rest.example.rest.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "event")
public class Event {
                        //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;

    @JsonProperty
    private String created;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @Column(name = "start_date")
    @JsonProperty
    private String startDate;

    @Column(name = "end_date")
    @JsonProperty
    private String endDate;

    @Column(name = "zone_id")
    @JsonProperty
    private String zoneId;

    @JsonProperty
    private int started;

    //@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //, cascade = CascadeType.MERGE
    //@JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    @JoinColumn(name = "organizer_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    @JsonProperty
    private Organizer organizer;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "venue_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    @JsonProperty
    private Venue venue;

    @OneToMany(cascade = CascadeType.ALL)
    //@JsonBackReference
    @JsonManagedReference
    @JsonProperty
    //@JsonIgnore
    private List<Participant> listParticipant = new ArrayList<Participant>();


                        //CONSTRUCTOR
    public Event() {
    }

                        //BUILDER PATTERN
    public static class EventBuilder{
        //fields
         private int id;
         private String created;
         private String name;
         private String description;
         private String startDate;
         private String endDate;
         private String zoneId;
         private int started;
         private Organizer organizer;
         private Venue venue;
         private List<Participant> listParticipant = new ArrayList<Participant>();

         //constructors
         public EventBuilder(){
         }
         public static EventBuilder anEvent(){
             return new EventBuilder();
         }

         //methods "with"
         public EventBuilder withId(int id){
             this.id = id;
             return this;
         }
         public EventBuilder withCreated(String created){
             this.created = created;
             return this;
         }
         public EventBuilder withName(String name){
             this.name = name;
             return this;
         }
         public EventBuilder withDescription(String description){
             this.description = description;
             return this;
         }
         public EventBuilder withStartDate(String startDate){
             this.startDate = startDate;
             return this;
         }
         public EventBuilder withEndDate(String endDate){
             this.endDate = endDate;
             return this;
         }
         public EventBuilder withZoneId(String zoneId){
             this.zoneId = zoneId;
             return this;
         }
         public EventBuilder withStarted(int started){
             this.started = started;
             return this;
         }
         public EventBuilder withOrganizer(Organizer organizer){
             this.organizer = organizer;
             return this;
         }
         public EventBuilder withVenue(Venue venue){
             this.venue = venue;
             return this;
         }
         public EventBuilder withListParticipant(List<Participant> listParticipant){
             this.listParticipant = listParticipant;
             return this;
         }

         //constructor "build" of main class Event
         public Event build(){
             Event event = new Event();
                event.id = this.id;
                event.created = this.created;
                event.name = this.name;
                event.description = this.description;
                event.startDate = this.startDate;
                event.endDate = this.endDate;
                event.zoneId = this.zoneId;
                event.started = this.started;
                event.organizer = this.organizer;
                event.venue = this.venue;
                event.listParticipant = this.listParticipant;
             return event;
         }
    }

                        //HASHCODE AND EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (started != event.started) return false;
        if (created != null ? !created.equals(event.created) : event.created != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (startDate != null ? !startDate.equals(event.startDate) : event.startDate != null) return false;
        if (endDate != null ? !endDate.equals(event.endDate) : event.endDate != null) return false;
        if (zoneId != null ? !zoneId.equals(event.zoneId) : event.zoneId != null) return false;
        if (organizer != null ? !organizer.equals(event.organizer) : event.organizer != null) return false;
        if (venue != null ? !venue.equals(event.venue) : event.venue != null) return false;
        return listParticipant != null ? listParticipant.equals(event.listParticipant) : event.listParticipant == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (zoneId != null ? zoneId.hashCode() : 0);
        result = 31 * result + started;
        result = 31 * result + (organizer != null ? organizer.hashCode() : 0);
        result = 31 * result + (venue != null ? venue.hashCode() : 0);
        result = 31 * result + (listParticipant != null ? listParticipant.hashCode() : 0);
        return result;
    }

    //SETTERS AND GETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getZoneId() {
        return zoneId;
    }
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }
    public int getStarted() {
        return started;
    }
    public void setStarted(int started) {
        this.started = started;
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
    public List<Participant> getListParticipant() {
        return listParticipant;
    }
    public void setListParticipant(List<Participant> listParticipant) {
        this.listParticipant = listParticipant;
    }
}
