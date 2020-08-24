package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import rest.example.rest.model.Event;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)//if some "null" value comes via request
@Generated("com.robohorse.robopojogenerator")       //then that null value it will not be shown as json answer
public class ParticipantResponse {
    //fields
    @JsonProperty
    private String name;

    @JsonProperty
    private String email;

    @JsonProperty
    private Event event;

    //constructor
    public ParticipantResponse(){}


    //BUILDER PATTERN
    public static class ParticipantResponseBuilder{
        //fields
        private String name;
        private String email;
        private Event event;

        //constructor
        public ParticipantResponseBuilder(){}
        public static ParticipantResponseBuilder anParticipantResponse(){
            return new ParticipantResponseBuilder();
        }

        //with
        public ParticipantResponseBuilder withName(String name){
            this.name = name;
            return this;
        }
        public ParticipantResponseBuilder withEmail(String email){
            this.email = email;
            return this;
        }
        public ParticipantResponseBuilder withEvent(Event event){
            this.event = event;
            return this;
        }

        //constructor "build" of main class ParticipantResponse
        public ParticipantResponse build(){
            ParticipantResponse participantResponse = new ParticipantResponse();
                participantResponse.name = this.name;
                participantResponse.email = this.email;
                participantResponse.event = this.event;
            return participantResponse;
        }
    }


    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantResponse that = (ParticipantResponse) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return event != null ? event.equals(that.event) : that.event == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }

    //setters and getters
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
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
