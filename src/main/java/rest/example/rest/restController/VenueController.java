package rest.example.rest.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest.example.rest.exception.ModelNotFoundException;
import rest.example.rest.model.Venue;
import rest.example.rest.msg.AddVenueRequest;
import rest.example.rest.msg.VenueRequest;
import rest.example.rest.repository.VenueRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("apiVenue")
public class VenueController {

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venues")
    public List<Venue> getVenues(){
        return venueRepository.findAll();
    }

    @GetMapping("/venue")
        public Optional<Venue> getVenue(@RequestParam("id") int id){
        if( id >= venueRepository.findAll().size() || id < 0 ){
            throw new ModelNotFoundException("Venue id not found - " + id);
        }

        return venueRepository.findById(id);
    }

    //search
    @PostMapping("/venuess")
    public List<Venue> getVenueRequest(@RequestBody VenueRequest venueRequest){
            return venueRepository.findByIdAndNameAndStreetAddressAndCountryAndPostalCode(venueRequest.getId(),
                    venueRequest.getName(), venueRequest.getStreetAddress(), venueRequest.getCountry(), venueRequest.getPostalCode());
    }


    //test for adding new organizer
    @PostMapping(path = "/vannnues", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Venue addVenue(@RequestBody AddVenueRequest addVenueRequest){
        Venue venue = new Venue();
            venue.setId(0);
            venue.setCreated("2020-05-06");
            venue.setName(addVenueRequest.getName());
            venue.setStreetAddress(addVenueRequest.getStreetAddress());
            venue.setStreetAddress2("no name proba");
            venue.setCity("Beograd");
            venue.setCountry(addVenueRequest.getCountry());
            venue.setPostalCode(addVenueRequest.getPostalCode());

        venueRepository.save(venue);

        return venue;
    }

}
