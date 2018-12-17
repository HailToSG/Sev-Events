package itc.sevevents.service;

import itc.sevevents.domain.Event;
import itc.sevevents.repos.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
    public void insert (Event event){
        eventRepo.save(event);
    }

    public void remove (Event event){
        eventRepo.delete(event);
    }

    public Event save(Event event) {
       return eventRepo.save(event);
    }

//    public Event get(Long id) {
//       return eventRepo.findById(id);
//    }
}
