export class Event {
    public creator: string;
    public title: string;
    public time: string;
    public attendees: string[];

    constructor(creator: string, title: string, time: string) {
        this.creator = creator;
        this.title = title;
        this.time = time;
        this.attendees = [];
    }
}   