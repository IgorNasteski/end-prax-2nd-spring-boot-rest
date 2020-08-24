package rest.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.example.rest.model.Venue;
import rest.example.rest.msg.VenueRequest;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
    public List<Venue> findByIdAndNameAndStreetAddressAndCountryAndPostalCode(int id, String Name, String streetAddress, String country, String postalCode);
}
