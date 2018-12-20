package itc.sevevents.controllers;


import itc.sevevents.domain.Event;
import itc.sevevents.service.EventService;
import itc.sevevents.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EventController {
    private EventService eventService;
    private UserService userService;

    @Autowired
    public EventController (EventService eventService, UserService userService){
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/events")
    public List<Event> events(){
        return eventService.getAllEvents();
    }

    @PostMapping ("/events/post")
    public void publish(@RequestBody Event event){
        eventService.saveEvent(event);
    }

    @PutMapping("/events/post/{id}")
    public Event update (
            @PathVariable("id") Event eventFromDb,
            @RequestBody Event event){
        BeanUtils.copyProperties(event, eventFromDb, "id");
        return eventService.saveEvent(eventFromDb);
    }

    @GetMapping("/events/{id}")
    public Event getOne(@PathVariable("id") Event event) {
        return eventService.getEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public void delete(@PathVariable("id") Event event){
        eventService.removeEvent(event);
    }
}

