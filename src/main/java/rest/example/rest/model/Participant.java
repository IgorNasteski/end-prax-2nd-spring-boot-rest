package rest.example.rest.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "participant")
public class Participant {
                                //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    @Column(name = "checked_in")
    @JsonProperty
    private int checked;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //, cascade = CascadeType.MERGE
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    //@JsonManagedReference
    @JsonBackReference
    @JsonProperty
    private Event event;

                                //CONSTRUCTOR
    public Participant() {
    }


                                //BUILDER PATTERN
    public static class ParticipantBuilder{
        //fields
        private int id;
        private String name;
        private String email;
        private int checked;
        private Event event;

        //constructors
        public ParticipantBuilder(){
        }
        public static ParticipantBuilder anParticipant(){
            return new ParticipantBuilder();
        }

        //methods "with"
        public ParticipantBuilder withId(int id){
            this.id = id;
            return this;
        }
        public ParticipantBuilder withName(String name){
            this.name = name;
            return this;
        }
        public ParticipantBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        public ParticipantBuilder withChecked(int checked){
            this.checked = checked;
            return this;
        }
        public ParticipantBuilder withEvent(Event event){
            this.event = event;
            return this;
        }

        //constructor "build" of main class Participant
        public Participant build(){
            Participant participant = new Participant();
                participant.id = this.id;
                participant.name = this.name;
                participant.email = this.email;
                participant.checked = this.checked;
                participant.event = this.event;
            return participant;
        }
    }

                                //HASHCODE AND EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (id != that.id) return false;
        if (checked != that.checked) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return event != null ? event.equals(that.event) : that.event == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + checked;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }

    //SETTERS AND GETTERS
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getChecked() {
        return checked;
    }
    public void setChecked(int checked) {
        this.checked = checked;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
