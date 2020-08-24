package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VenueRequest {
    //fields
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String streetAddress;

    @JsonProperty
    private String country;

    @JsonProperty
    private String postalCode;

    //constructor
    public VenueRequest() {
    }

    //BUILDER PATTERN
    public static class VenueRequestBuilder{
        //fields
        private int id;
        private String name;
        private String streetAddress;
        private String country;
        private String postalCode;

        //constructor
        public VenueRequestBuilder(){}
        public static VenueRequestBuilder anVenueRequest(){
            return new VenueRequestBuilder();
        }

        //with
        public VenueRequestBuilder withId(int id){
            this.id = id;
            return this;
        }
        public VenueRequestBuilder withName(String name){
            this.name = name;
            return this;
        }
        public VenueRequestBuilder withStreetAddress(String streetAddress){
            this.streetAddress = streetAddress;
            return this;
        }
        public VenueRequestBuilder withCountry(String country){
            this.country = country;
            return this;
        }
        public VenueRequestBuilder withPostalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        //constructor "build" of main class VenueRequest
        public VenueRequest build(){
            VenueRequest venueRequest = new VenueRequest();
                venueRequest.id = this.id;
                venueRequest.name = this.name;
                venueRequest.streetAddress = this.streetAddress;
                venueRequest.country = this.country;
                venueRequest.postalCode = this.postalCode;
            return venueRequest;
        }


    }


    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VenueRequest that = (VenueRequest) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (streetAddress != null ? !streetAddress.equals(that.streetAddress) : that.streetAddress != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return postalCode != null ? postalCode.equals(that.postalCode) : that.postalCode == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
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
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
