import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {IEvent} from "../shared/IEvent";
import {HttpClient} from "@angular/common/http";
import {AppSettings} from "../other/AppSettings";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl:string = AppSettings.API_ENDPOINT + 'event';
  constructor(private http: HttpClient) { }
  public getEvents(): Observable<IEvent[]>{
    return this.http.get<IEvent[]>(this.baseUrl+'/findAll');
  }
  public getEvent(id: number): Observable<IEvent>{
    return this.http.get<IEvent>(this.baseUrl + '/findById/' + id);
  }
  public updateEvent(event: IEvent): Observable<IEvent>{
    return this.http.put<IEvent>(this.baseUrl + '/update/' + event.id, event);
  }
  public addEvent(event: IEvent): Observable<IEvent>{
    return this.http.post<IEvent>(this.baseUrl + '/addEvent', event);
  }
  public deleteEvent(event: IEvent): Observable<IEvent>{
    return this.http.delete<IEvent>(this.baseUrl + '/delete/' + event.id);
  }
}
