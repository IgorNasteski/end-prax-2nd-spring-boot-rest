package rest.example.rest.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest.example.rest.exception.ModelNotFoundException;
import rest.example.rest.model.Event;
import rest.example.rest.model.Participant;
import rest.example.rest.msg.AddParticipantRequest;
import rest.example.rest.msg.ParticipantRequest;
import rest.example.rest.msg.ParticipantResponse;
import rest.example.rest.repository.EventRepository;
import rest.example.rest.repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiParticipant")
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/participants")
    public List<Participant> getParticipants(){
        return participantRepository.findAll();
    }

    @GetMapping("/participants/{id}")
    public Optional<Participant> getParticipant(@PathVariable int id){
        if( id >= participantRepository.findAll().size() || id < 0 ){
            throw new ModelNotFoundException("Participant id not found - " + id);
        }

        return participantRepository.findById(id);
    }




    //search
    @PostMapping(value = "/participantss")//==, headers = {"clientId=pustaj"})//filter chaining u config klasi security, a ovde ukidam
    public Participant getParticipantRequest(@RequestBody ParticipantRequest participantRequest){
            int id = participantRequest.getId();
            String name = participantRequest.getName();
            int checked = participantRequest.getChecked();
        //ParticipantRequest.ParticipantRequestBuilder.anParticipantRequest().withId(id).withName(name).withChecked(checked).build();

        return participantRepository.findByIdAndNameAndChecked(id, name, checked);
    }

    //search - ja mu prosledim 3 parametra koje sadrzi klasa ParticipantRequest a to  otpakujem i zapakujem kao prikaz
    //u ParticipantResponse koji ima 2 parametra(ta dva parametra zelim samo da mi ispise, a ne sva polja Participanta)
    //zato sam i kreirao ParticipantResponse(ima 2 parametara i samo ta 2 zelim da mi ispise kad prosledim taj objekat)
    @PostMapping(value = "/participantsa", headers = {"clientId=pustaj"})
    public ParticipantResponse getParticipantRequestAndSendItToResponse(@RequestBody ParticipantRequest participantRequest){
            //fields that i type as json and send as post request via Postman
            int id = participantRequest.getId();
            String name = participantRequest.getName();
            int checked = participantRequest.getChecked();

        //finding participant from db with that fields
        Participant participant = participantRepository.findByIdAndNameAndChecked(id, name, checked);

            //getting fields name and event from participant that we recently found
            String partName = participant.getName();
            Event partEvent = participant.getEvent();

        //building ParticipantResponse object(only have name and Event as fields) via BuilderPattern from that class
        //and setting that 2 fields that class contains... And that object(with 2 fields, not whole Participant) will be printed as json answer in Postman
        ParticipantResponse participantResponse = ParticipantResponse.ParticipantResponseBuilder.anParticipantResponse()
                .withName(partName).withEmail(participant.getEmail()).withEvent(partEvent).build();

        return participantResponse;
    }
    //just to check if some "null" value comes via request will be shown in Participant Json answer in Postman
    //email is null in database, and it will be shown as answer... and after adding @JsonInclude(JsonInclude.Include.NON_NULL)
    //in Participant class, that email is ignored... Json response in Postman doesn't show email
    @PostMapping("/participan")
    public Participant getParticipanta(@RequestBody ParticipantRequest participantRequest){
        Participant participant = participantRepository.findByIdAndNameAndChecked(participantRequest.getId(),
                participantRequest.getName(), participantRequest.getChecked());

        return participant;
    }



    //test for adding new participant
    @PostMapping(path = "/participanttts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Participant addParticipant(@RequestBody AddParticipantRequest addParticipantRequest){

        Participant participant = new Participant();
            participant.setId(0);
            participant.setName(addParticipantRequest.getName());
            participant.setEmail("proba@gmail.com");
            participant.setChecked(addParticipantRequest.getChecked());
        Event event = eventRepository.findById(1).orElse(null);
            participant.setEvent(event);

        participantRepository.save(participant);

        return participant;
    }


}