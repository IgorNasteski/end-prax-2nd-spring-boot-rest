package rest.example.rest.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.example.rest.exception.ModelNotFoundException;
import rest.example.rest.model.LogEvent;
import rest.example.rest.model.Organizer;
import rest.example.rest.repository.LogEventRepository;
import rest.example.rest.repository.OrganizerRepository;
import rest.example.rest.msg.OrganizerRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiOrganizer")
public class OrganizerController {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private LogEventRepository logEventRepository;

    @GetMapping("/organizers")
    public List<Organizer> getOrganizers(){
        return organizerRepository.findAll();
    }

    //UNDER THIS METHOD IS 2 METHODS EXCEPTION HANDLING FOR THIS METHOD(if i type negative number
    //for organizer or id that is > size of list Organizers, or if i type some text...
    //THAT CODE IS MOVED IN ExceptionHandlerForAllRestController class, and that class
    //will intercept every @RestController class and handle exception if occurred
    //returns one specific organizer via his id named "id" in entity class "Organizer"
    @GetMapping("/organizers/{id}")
    public Optional<Organizer> getOrganizer(@PathVariable int id){
        //check the id against list size. If id is < 0 or > size() of List Organizers
        if( (id >= organizerRepository.findAll().size() || id < 0) ){
            throw new ModelNotFoundException("Organizer id not found - " + id);
        }

        //if everything is ok, if id is in the range of List Organizers, return that organizer
        return organizerRepository.findById(id);
    }

    //search
    @PostMapping("/organizerss")
    public Organizer getOrganizerRequest(@RequestBody OrganizerRequest organizerRequest){
        return organizerRepository.findByIdAndName(organizerRequest.getId(), organizerRequest.getName());
    }



    //test for adding new organizer
    @PostMapping(path = "/organizerrs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Organizer addOrganizer(@RequestBody Organizer organizer){
        organizer.setId(0);
        System.out.println("organizer id " + organizer.getId() + ",name " + organizer.getName() + ",created " +organizer.getCreated());

        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Test time1 " + dateFormat.format(date)); //2016-11-16 12:08:43

        String dateTime = dateFormat.format(date).toString();
        System.out.println("Test time2 " + dateTime);

        LogEvent logEvent = LogEvent.LogEventBuilder.anLogEvent().withDescription("user has added new organizer")
                                                                 .withCategory("add new").withStatus("successful").withDateTime(dateTime).build();
        logEventRepository.save(logEvent);*/

        organizerRepository.save(organizer);
        return organizer;
    }

    //update
    @PutMapping("/organizersUpdate")
    public ResponseEntity<Object> updateOrganizer(@RequestBody OrganizerRequest organizerRequest){
        Organizer organizer = organizerRepository.findById(organizerRequest.getId()).orElse(null);

        //set name
        organizer.setName(organizerRequest.getName());

        organizerRepository.save(organizer);
        return new ResponseEntity<>("The organizer is successfully updated.", HttpStatus.OK);
    }






}
