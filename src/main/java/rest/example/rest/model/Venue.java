package rest.example.rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "venue")
public class Venue {
                                //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private int id;

    @JsonProperty
    private String created;

    @JsonProperty
    private String name;

    @Column(name = "street_address")
    @JsonProperty
    private String streetAddress;

    @Column(name = "street_address2")
    @JsonProperty
    private String streetAddress2;

    @JsonProperty
    private String city;

    @JsonProperty
    private String country;

    @Column(name = "postal_code")
    @JsonProperty
    private String postalCode;

    @OneToOne(mappedBy = "venue")
    @JsonBackReference
    @JsonProperty
    private Event event;


                                //CONSTRUCTOR
    public Venue(){
    }

                                //BUILDER PATTERN
    public static class VenueBuilder{
        //fields
        private int id;
        private String created;
        private String name;
        private String streetAddress;
        private String streetAddress2;
        private String city;
        private String country;
        private String postalCode;
        private Event event;

        //constructors
        public VenueBuilder(){
        }
        public static VenueBuilder anVenue(){
            return new VenueBuilder();
        }

        //methods "with"
        public VenueBuilder withId(int id){
            this.id = id;
            return this;
        }
        public VenueBuilder withCreated(String created){
            this.created = created;
            return this;
        }
        public VenueBuilder withName(String name){
            this.name = name;
            return this;
        }
        public VenueBuilder withStreetAddress(String streetAddress){
            this.streetAddress = streetAddress;
            return this;
        }
        public VenueBuilder withStreetAddress2(String streetAddress2){
            this.streetAddress2 = streetAddress2;
            return this;
        }
        public VenueBuilder withCity(String city){
            this.city = city;
            return this;
        }
        public VenueBuilder withCountry(String country){
            this.country = country;
            return this;
        }
        public VenueBuilder withPostalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }
        public VenueBuilder withEvent(Event event){
            this.event = event;
            return this;
        }

        //constructor "build" of main class Venue
        public Venue build(){
            Venue venue = new Venue();
                venue.id = this.id;
                venue.created = this.created;
                venue.name = this.name;
                venue.streetAddress = this.streetAddress;
                venue.streetAddress2 = this.streetAddress2;
                venue.city = this.city;
                venue.country = this.country;
                venue.postalCode = this.postalCode;
                venue.event = this.event;
            return venue;
        }
    }

                                //HASHCODE AND EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        if (id != venue.id) return false;
        if (created != null ? !created.equals(venue.created) : venue.created != null) return false;
        if (name != null ? !name.equals(venue.name) : venue.name != null) return false;
        if (streetAddress != null ? !streetAddress.equals(venue.streetAddress) : venue.streetAddress != null)
            return false;
        if (streetAddress2 != null ? !streetAddress2.equals(venue.streetAddress2) : venue.streetAddress2 != null)
            return false;
        if (city != null ? !city.equals(venue.city) : venue.city != null) return false;
        if (country != null ? !country.equals(venue.country) : venue.country != null) return false;
        if (postalCode != null ? !postalCode.equals(venue.postalCode) : venue.postalCode != null) return false;
        return event != null ? event.equals(venue.event) : venue.event == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (streetAddress2 != null ? streetAddress2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
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
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getStreetAddress2() {
        return streetAddress2;
    }
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
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
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
}
