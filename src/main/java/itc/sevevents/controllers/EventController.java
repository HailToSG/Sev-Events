package itc.sevevents.controllers;


import itc.sevevents.domain.Event;
import itc.sevevents.repos.EventRepo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventRepo eventRepo;

    @Autowired
    public EventController(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @GetMapping
    public List<Event> list() {
        return eventRepo.findAll();
    }

    @GetMapping("{id}")
    public Event getOne(@PathVariable("id") Event event) {
        return event;
    }

    @PostMapping
    Event create(@RequestBody Event comment){
        return eventRepo.save(comment);
    }

    @PutMapping("{id}")
    public Event update (
            @PathVariable("id") Event eventFromDb,
            @RequestBody Event event){
        BeanUtils.copyProperties(event, eventFromDb, "id");
        return eventRepo.save(eventFromDb);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Event event){
        eventRepo.delete(event);
    }
}

