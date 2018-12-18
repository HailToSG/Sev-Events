package itc.sevevents.service;

import itc.sevevents.domain.Event;
import itc.sevevents.repos.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public void removeEvent(Event event){
        eventRepo.delete(event);
    }

    public Event saveEvent(Event event) {
       return eventRepo.save(event);
    }

    public Event getEvent(Event event) {
       return eventRepo.getOne(event.getId());
    }
}
