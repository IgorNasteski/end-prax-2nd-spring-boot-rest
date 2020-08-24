package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class OrganizerRequest {
    //fields
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    //constructor
    public OrganizerRequest(){}


    //BUILDER PATTERN
    public static class OrganizerRequestBuilder{
        //fields
        private int id;
        private String name;

        //constructor
        public OrganizerRequestBuilder(){}
        public static OrganizerRequestBuilder anOrganizerRequest(){
            return new OrganizerRequestBuilder();
        }

        //with
        public OrganizerRequestBuilder withId(int id){
            this.id = id;
            return this;
        }
        public OrganizerRequestBuilder withName(String name){
            this.name = name;
            return this;
        }

        //constructor "build" of main class OrganizerRequest
        public OrganizerRequest build(){
            OrganizerRequest organizerRequest = new OrganizerRequest();
                organizerRequest.id = this.id;
                organizerRequest.name = this.name;
            return organizerRequest;
        }

    }

    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizerRequest that = (OrganizerRequest) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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
}
