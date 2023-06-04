import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {IEvent} from "../shared/IEvent";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl:string = 'http://localhost:8080/event';
  constructor(private http: HttpClient) { }
  public getEvents(): Observable<IEvent[]>{
    return this.http.get<IEvent[]>(this.baseUrl+'/getAll');

  }
}
