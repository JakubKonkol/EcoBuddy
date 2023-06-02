package pl.pjatk.ecobuddyserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjatk.ecobuddyserver.model.Event;
import pl.pjatk.ecobuddyserver.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
 EventRepository eventRepository;

 @Autowired
public void EventService(EventRepository eventRepository){this.eventRepository = eventRepository;}


    public Event createEvent(Event event){ return eventRepository.save(event);}

    public List<Event> getAllEvent() {return eventRepository.findAll();}


public Event getEvent(Long id){
    Optional<Event> event = eventRepository.findById(id);
    if(event.isPresent()){
        return event.get();
    }
    throw new IllegalArgumentException();
}
public void deleteEvent(Long id){eventRepository.deleteById(id);}

    public Event updateEvent(Long id, Event updatedEvent){
     Event eventToUpdate = getEvent(id);
     if (updatedEvent.getDate() != null){
         eventToUpdate.setDate(updatedEvent.getDate());
     }
     if(updatedEvent.getDescription() != null){
         eventToUpdate.setDescription(updatedEvent.getDescription());
     }
     if(updatedEvent.getImg() != null){
         eventToUpdate.setImg(updatedEvent.getImg());
     }
     return  eventRepository.save(eventToUpdate);
    }
}
