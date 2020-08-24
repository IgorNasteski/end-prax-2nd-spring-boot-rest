package rest.example.rest.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest.example.rest.exception.ModelNotFoundException;
import rest.example.rest.model.Event;
import rest.example.rest.model.Organizer;
import rest.example.rest.model.Venue;
import rest.example.rest.msg.AddEventRequest;
import rest.example.rest.msg.EventRequest;
import rest.example.rest.msg.EventResponse;
import rest.example.rest.repository.EventRepository;
import rest.example.rest.repository.OrganizerRepository;
import rest.example.rest.repository.VenueRepository;

import java.util.List;
import java.util.Optional;

@RestController//ne mora iznad metoda da stavljam @ResponseBody jer @ResponseBody sadrzi @RestController
@RequestMapping("/apiEvent")        //da sam stavio da je ova klasa @Controller onda bih morao da stavljam iznad metoda
public class EventController {      //@ResponseBody i u tom slucaju bi radilo... jer obican @Controller nema @ResponseBody

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    @GetMapping("/events/{id}")
    public Optional<Event> getEvent(@PathVariable int id){
        if( id >= eventRepository.findAll().size() || id < 0 ){
            throw new ModelNotFoundException("Event id not found - " + id);
        }

        return eventRepository.findById(id);
    }

    //search
    @PostMapping("/eventss")
    public Event getEventRequest(@RequestBody EventRequest eventRequest){
        return eventRepository.findByIdAndCreatedAndNameAndDescription(eventRequest.getId(), eventRequest.getCreated(), eventRequest.getName(), eventRequest.getDescription());
    }

    //search - ja mu prosledim 4 parametra koje sadrzi klasa EventRequest a to  otpakujem i zapakujem kao prikaz
    //u EventResponse koji ima 3 parametra(ta dva parametra zelim samo da mi ispise kao json odgovor u Postmanu, a ne sva polja Eventa)
    //zato sam i kreirao EventResponse(ima 3 parametara i samo ta 2 zelim da mi ispise kad prosledim taj objekat)
    @PostMapping("/eventsa")
    public EventResponse getEventRequestAndPopulateEventResponseClassForViewFieldsOfResponseClass(@RequestBody EventRequest eventRequest){
        //finding event from db with that fields
        Event event = eventRepository.findByIdAndCreatedAndNameAndDescription(eventRequest.getId(), eventRequest.getCreated(),
                                                                            eventRequest.getName(), eventRequest.getDescription());

            //just for me to check in console
            System.out.println("id " + event.getId() + " created " + event.getCreated() + " name " + event.getName() +  " description " + event.getDescription());

        //building EventResponse object(only have name, organizer and venue as fields) via BuilderPattern from that class
        //and setting that 3 fields that class contains... And that object(with 3 fields, not whole Event) will be printed as json answer in Postman
        EventResponse eventResponse = EventResponse.EventResponseBuilder.anEventResponse().
                        withName(event.getName()).
                        withOrganizer(event.getOrganizer()).
                        withVenue(event.getVenue()).build();

        return eventResponse;
    }









    //@RequestMapping(method = RequestMethod.POST, path = "/crashAssistance", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //ZA RESPONSE MAPPING ----  produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    //ZA REQUEST MAPPING ---- consumes = MediaType.APPLICATION_JSON_UTF8_VALUE

    //@RequestMapping(method = RequestMethod.POST, path = "/eventsaaa", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping(path = "/eventsaaa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EventResponse gettEventRequestAndPopulateEventResponseClassForViewFieldsOfResponseClass(EventRequest eventRequest){
        System.out.println("id " + eventRequest.getId() + " created " + eventRequest.getCreated() + " name " + eventRequest.getName() +  " description " + eventRequest.getDescription());
        //KADA UKLONIM @RequestBody DOBIJAM NULL ZA SVA POLJA. SVAKAKO SAM DODAO U KLASI
        //EventRequest IZNAD SVAKOG POLJA @JsonProperty, IZNAD NAZIVA KLASE @Generated("com.robohorse.robopojogenerator")

        //fields that i type as json and send as post request via Postman
        int id = eventRequest.getId();
        String created = eventRequest.getCreated();
        String name = eventRequest.getName();
        String description = eventRequest.getDescription();

        Event event = eventRepository.findByIdAndCreatedAndNameAndDescription(id, created, name, description);

        //just for me to check in console
        System.out.println("id " + event.getId() + " created " + event.getCreated() + " name " + event.getName() +  " description " + event.getDescription());


        EventResponse eventResponse = EventResponse.EventResponseBuilder.anEventResponse().
                withName(event.getName()).
                withOrganizer(event.getOrganizer()).
                withVenue(event.getVenue()).build();

        return eventResponse;
    }

    //test for adding new organizer
    @PostMapping(path = "/eventas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event addEvent(@RequestBody AddEventRequest addEventRequest){

        Event event = new Event();

        //Organizer organizer = organizerRepository.findById(1).orElse(null);
        //Venue venue = venueRepository.findById(1).orElse(null);

        event.setId(0);
        event.setCreated(addEventRequest.getCreated());
        event.setName(addEventRequest.getName());
        event.setDescription(addEventRequest.getDescription());

        event.setStartDate("2020-05-06");
        event.setEndDate("2020-05-07");
        event.setZoneId("Europe");
        event.setStarted(5);
        event.setOrganizer(addEventRequest.getOrganizer());
        event.setVenue(addEventRequest.getVenue());

        eventRepository.save(event);
        return event;
    }

}






/*System.out.println("event id " + event.getId() + ",created " +event.getCreated() +
        ",name " + event.getName() + ",description " + event.getDescription() +
        ",start date " + event.getStartDate() + ",end date " + event.getEndDate() +
        ",zone id " + event.getZoneId() + ",started " + event.getStarted() +
        " organizer id " + event.getOrganizer().getId() + " venue id " + event.getVenue().getId());*/
