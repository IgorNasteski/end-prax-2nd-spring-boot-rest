package rest.example.rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "organizer")
public class Organizer {

                        //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String created;

    //@OneToOne(mappedBy = "organizer", orphanRemoval= true)
    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JsonProperty
    private List<Event> event = new ArrayList<Event>();


                        //CONSTRUCTOR
    public Organizer() {
    }

                        //BUILDER PATTERN
    public static class OrganizerBuilder{

        //fields
        private int id;
        private String name;
        private String created;
        private List<Event> event;

        //constructors
        public OrganizerBuilder(){}

        public static OrganizerBuilder anOrganizer(){
            return new OrganizerBuilder();
        }

        //methods "with"
        public OrganizerBuilder withId(int id){
            this.id = id;
            return this;
        }
        public OrganizerBuilder withName(String name){
            this.name = name;
            return this;
        }
        public OrganizerBuilder withCreated(String created){
            this.created = created;
            return this;
        }
        public OrganizerBuilder withEvent(List<Event> event){
            this.event = event;
            return this;
        }

        //constructor "build" of main class Organizer
        public Organizer build(){
            Organizer organizer = new Organizer();
                organizer.id = this.id;
                organizer.name = this.name;
                organizer.created = this.created;
                organizer.event= this.event;
            return organizer;
        }

    }




                        //HASHCODE AND EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organizer organizer = (Organizer) o;

        if (id != organizer.id) return false;
        if (name != null ? !name.equals(organizer.name) : organizer.name != null) return false;
        if (created != null ? !created.equals(organizer.created) : organizer.created != null) return false;
        return event != null ? event.equals(organizer.event) : organizer.event == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }


                        //GETERS AND SETTERS

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public List<Event> getEvent() {
        return event;
    }
    public void setEvent(List<Event> event) {
        this.event = event;
    }
    /*public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }*/
}
