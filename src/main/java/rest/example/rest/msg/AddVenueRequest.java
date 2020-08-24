package rest.example.rest.msg;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AddVenueRequest {
    //fields
    @JsonProperty
    private String name;

    @JsonProperty
    private String streetAddress;

    @JsonProperty
    private String country;

    @JsonProperty
    private String postalCode;

    //constructor
    public AddVenueRequest() {
    }

    //BUILDER PATTERN
    public static class AddVenueRequestBuilder{
        //fields
        private String name;
        private String streetAddress;
        private String country;
        private String postalCode;

        //constructor
        public AddVenueRequestBuilder(){}
        public static AddVenueRequestBuilder anAddVenueRequest(){
            return new AddVenueRequestBuilder();
        }

        //with
        public AddVenueRequestBuilder withName(String name){
            this.name = name;
            return this;
        }
        public AddVenueRequestBuilder withStreetAddress(String streetAddress){
            this.streetAddress = streetAddress;
            return this;
        }
        public AddVenueRequestBuilder withCountry(String country){
            this.country = country;
            return this;
        }
        public AddVenueRequestBuilder withPostalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        //constructor "build" of main class VenueRequest
        public AddVenueRequest build(){
            AddVenueRequest addVenueRequest = new AddVenueRequest();
            addVenueRequest.name = this.name;
            addVenueRequest.streetAddress = this.streetAddress;
            addVenueRequest.country = this.country;
            addVenueRequest.postalCode = this.postalCode;
            return addVenueRequest;
        }


    }


    //hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddVenueRequest that = (AddVenueRequest) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (streetAddress != null ? !streetAddress.equals(that.streetAddress) : that.streetAddress != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }

    //getters and setters
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
