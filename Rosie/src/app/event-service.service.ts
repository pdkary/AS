import { Injectable } from '@angular/core';
import { Event } from './event';

@Injectable({
  providedIn: 'root'
})
export class EventServiceService {
  events: Event[] = new Array(0);

  constructor() { }

  get(): Event[] {
    this.events.push(new Event("Parker","Evo","8:00pm"),new Event("Richard","Catan","9:00pm"));
    return this.events;
  }
}
