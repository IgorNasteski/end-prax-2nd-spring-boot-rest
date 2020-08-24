package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class EventRequest {
    //FIELDS
    @JsonProperty("id")
    private int id;

    @JsonProperty("created")
    private String created;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;


    //CONSTRUCTOR
    public EventRequest() {
    }

    //BUILDER PATTERN
    public static class EventRequestBuilder{
        //fields
        private int id;
        private String created;
        private String name;
        private String description;

        //constructors
        public EventRequestBuilder(){}
        public static EventRequestBuilder anEventRequest(){
            return new EventRequestBuilder();
        }

        //with
        public EventRequestBuilder withId(int id){
            this.id = id;
            return this;
        }
        public EventRequestBuilder withCreated(String created){
            this.created = created;
            return this;
        }
        public EventRequestBuilder withName(String name){
            this.name = name;
            return this;
        }
        public EventRequestBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        //constructor "build" of main class EventRequest
        public EventRequest build(){
            EventRequest eventRequest = new EventRequest();
                eventRequest.id = this.id;
                eventRequest.created = this.created;
                eventRequest.name = this.name;
                eventRequest.description = this.description;
            return eventRequest;
        }

    }

    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventRequest that = (EventRequest) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
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

}
