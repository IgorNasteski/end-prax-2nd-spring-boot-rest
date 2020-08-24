package rest.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.example.rest.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

    public Event findByIdAndCreatedAndNameAndDescription(int id, String created, String name, String description);

}
