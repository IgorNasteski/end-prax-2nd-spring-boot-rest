package rest.example.rest.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.example.rest.model.LogEvent;
import rest.example.rest.repository.LogEventRepository;

import java.util.List;

@RestController
@RequestMapping("/logApi")
public class LogEventController {

    @Autowired
    private LogEventRepository logEventRepository;

    @GetMapping("/logs")
    public List<LogEvent> logs(){
        return logEventRepository.findAll();
    }
}
