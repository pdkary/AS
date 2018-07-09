import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from '../../node_modules/rxjs';
@Injectable({
  providedIn: 'root'
})
export class OmdbService {
  omdb: string = "http://www.omdbapi.com/?apikey=a4b74ff9&t=";
  query: string;
  title: string;
  constructor(
    private http: HttpClient,
  ) { }

  searchMovie(name: string): any {
    this.query = this.omdb + name;
    return this.http.get(this.query).subscribe(o => this.json(o));
  }

  getTitle(name: string): string {
    return this.searchMovie(name).subscribe(o => this.title = o.get("Title"));
  }

  private json(_body: any): any {
    if (typeof _body === 'string') {
      return JSON.parse(<string>_body);
    }
    return _body;
  }
}
