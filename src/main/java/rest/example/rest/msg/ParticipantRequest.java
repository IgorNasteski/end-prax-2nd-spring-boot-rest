package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@JsonIgnoreProperties //za request staviti
@Generated("com.robohorse.robopojogenerator")
public class ParticipantRequest {
    //fields
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private int checked;

    //constructor
    public ParticipantRequest(){}


    //BUILDER PATTERN
    public static class ParticipantRequestBuilder{
        //fields
        private int id;
        private String name;
        private int checked;

        //constructor
        public ParticipantRequestBuilder(){}
        public static ParticipantRequestBuilder anParticipantRequest(){
            return new ParticipantRequestBuilder();
        }

        //with
        public ParticipantRequestBuilder withId(int id){
            this.id = id;
            return this;
        }
        public ParticipantRequestBuilder withName(String name){
            this.name = name;
            return this;
        }
        public ParticipantRequestBuilder withChecked(int checked){
            this.checked = checked;
            return this;
        }

        //constructor "build" of main class ParticipantRequest
        public ParticipantRequest build(){
            ParticipantRequest participantRequest = new ParticipantRequest();
                participantRequest.id = this.id;
                participantRequest.name = this.name;
                participantRequest.checked = this.checked;
            return participantRequest;
        }

    }


    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantRequest that = (ParticipantRequest) o;

        if (id != that.id) return false;
        if (checked != that.checked) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + checked;
        return result;
    }

    //getters and setters
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
    public int getChecked() {
        return checked;
    }
    public void setChecked(int checked) {
        this.checked = checked;
    }
}
