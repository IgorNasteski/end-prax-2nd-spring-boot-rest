package rest.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.example.rest.model.LogEvent;

public interface LogEventRepository extends JpaRepository<LogEvent, Integer> {
}
