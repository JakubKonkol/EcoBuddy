package pl.pjatk.ecobuddyserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.ecobuddyserver.model.Event;
import pl.pjatk.ecobuddyserver.service.EventService;

@RestController
@RequestMapping("/assets")
public class EventController {
    EventService eventService;

    @Autowired
    public EventController(EventService eventService){this.eventService = eventService;}

    @PostMapping("/create")
    public ResponseEntity<Event>  createEvent(@RequestBody Event event){
        return  ResponseEntity.ok(eventService.createEvent(event));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEvent(@RequestParam("id") Long id){
        eventService.deleteEvent(id);
        return ResponseEntity.ok("ok");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent (@RequestBody Event event, @PathVariable("id") Long id){
       return  ResponseEntity.ok((eventService.updateEvent(id,event)));
    }

}
