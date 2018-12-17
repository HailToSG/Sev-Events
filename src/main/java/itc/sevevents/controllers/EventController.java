package itc.sevevents.controllers;


import itc.sevevents.domain.Event;
import itc.sevevents.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("/")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping ("/events")
    public List<Event> events(){
        return eventService.getAllEvents();
    }

    @PostMapping ("/event")
    public void publish(@RequestBody Event event){
        if (event.getDateCreated() == null){
            event.setDateCreated(new Date());
        }
        eventService.insert(event);
    }

    @PutMapping("event/{id}")
    public Event update (
            @PathVariable("id") Event eventFromDb,
            @RequestBody Event event){
        BeanUtils.copyProperties(event, eventFromDb, "id");
        return eventService.save(event);
    }

//    @GetMapping("{id}")
//    public Event getOne(@PathVariable("id") Event event) {
//        return eventService.get();
//    }


//    @PutMapping("{id}")
//    public Event update (
//            @PathVariable("id") Event eventFromDb,
//            @RequestBody Event event){
//        BeanUtils.copyProperties(event, eventFromDb, "id");
//        return eventRepo.save(eventFromDb);
//    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Event event){
        eventService.remove(event);
    }
}

