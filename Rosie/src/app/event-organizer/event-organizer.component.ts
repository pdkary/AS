import { Component, OnInit, NgModule } from '@angular/core';
import { EventServiceService } from "../event-service.service";
@Component({
  selector: 'app-event-organizer',
  templateUrl: './event-organizer.component.html',
  styleUrls: ['./event-organizer.component.css']
})
export class EventOrganizerComponent implements OnInit {

  events: Event[];
  constructor(private eventService: EventServiceService) { }

  ngOnInit() {
    this.events = this.eventService.get();
  }

}
