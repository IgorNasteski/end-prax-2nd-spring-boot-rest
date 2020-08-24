package rest.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.example.rest.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    public Participant findByIdAndName(int id, String name);
    public Participant findByIdAndNameAndChecked(int id, String name, int checked);
}
