package itc.sevevents.controllers;


import itc.sevevents.domain.Event;
import itc.sevevents.service.EventService;
import itc.sevevents.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.time.LocalDateTime.now;

@RestController("/events")
public class EventController {
    private EventService eventService;
    private UserService userService;

    @Autowired
    public EventController (EventService eventService, UserService userService){
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping
    public List<Event> events(){
        return eventService.getAllEvents();
    }

    @PostMapping ("/post")
    public void publish(@RequestBody Event event){
        if (event.getDateCreated() == null){
            event.setDateCreated(now());
        }
        eventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    public Event update (
            @PathVariable("id") Event eventFromDb,
            @RequestBody Event event){
        BeanUtils.copyProperties(event, eventFromDb, "id");
        return eventService.saveEvent(event);
    }

    @GetMapping("/{id}")
    public Event getOne(@PathVariable("id") Event event) {
        return eventService.getEvent(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Event event){
        eventService.removeEvent(event);
    }
}

