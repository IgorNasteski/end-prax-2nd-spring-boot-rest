package rest.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.example.rest.model.Organizer;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    public Organizer findByIdAndName(int id, String name);
    //public Optional<Organizer> save(Organizer organizer);
}
