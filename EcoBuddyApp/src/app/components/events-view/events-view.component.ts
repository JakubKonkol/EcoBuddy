import {Component, OnInit} from '@angular/core';
import {IEvent} from "../../shared/IEvent";
import {EventService} from "../../services/event.service";

@Component({
  selector: 'app-events-view',
  templateUrl: './events-view.component.html',
  styleUrls: ['./events-view.component.css']
})
export class EventsViewComponent implements OnInit{
  events: IEvent[] = [];
  KEY: string = 'AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8';
  constructor(private eventService: EventService) {
  }
  ngOnInit(): void {
    this.eventService.getEvents().subscribe(events => this.events = events);
  }
  formatDate(date: Date): string {
    return new Date(date).toLocaleDateString();
  }

}
