package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@JsonIgnoreProperties //za request staviti
@Generated("com.robohorse.robopojogenerator")
public class AddParticipantRequest {
    //fields
    @JsonProperty
    private String name;

    @JsonProperty
    private int checked;

    //constructor
    public AddParticipantRequest(){}


    //BUILDER PATTERN
    public static class AddParticipantRequestBuilder{
        //fields
        private String name;
        private int checked;

        //constructor
        public AddParticipantRequestBuilder(){}
        public static AddParticipantRequestBuilder anParticipantRequest(){
            return new AddParticipantRequestBuilder();
        }

        //with
        public AddParticipantRequestBuilder withName(String name){
            this.name = name;
            return this;
        }
        public AddParticipantRequestBuilder withChecked(int checked){
            this.checked = checked;
            return this;
        }

        //constructor "build" of main class ParticipantRequest
        public AddParticipantRequest build(){
            AddParticipantRequest addParticipantRequest = new AddParticipantRequest();
            addParticipantRequest.name = this.name;
            addParticipantRequest.checked = this.checked;
            return addParticipantRequest;
        }

    }


    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddParticipantRequest that = (AddParticipantRequest) o;

        if (checked != that.checked) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + checked;
        return result;
    }

    //getters and setters
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
