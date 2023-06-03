import { Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Goal} from "../shared/Goal";
import {IGoal} from "../shared/IGoal";
@Injectable({
  providedIn: 'root'
})
export class GoalService{
  private baseUrl:string = 'http://localhost:8080/goals';
  constructor(private http:HttpClient) { }
  public getGoals():Observable<IGoal[]>{
    return this.http.get<IGoal[]>(this.baseUrl);
  }
  public addMoneyToGoal(goal: IGoal):Observable<IGoal>{
    return this.http.put<IGoal>(this.baseUrl + '/' + goal.idGoal + '/add-money', goal);
  }
}
