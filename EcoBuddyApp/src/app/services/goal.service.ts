import { Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Goal} from "../shared/Goal";
import {IGoal} from "../shared/IGoal";
import {AppSettings} from "../other/AppSettings";
@Injectable({
  providedIn: 'root'
})
export class GoalService{
  private baseUrl:string = AppSettings.API_ENDPOINT + 'goal';
  constructor(private http:HttpClient) { }
  public getGoals():Observable<IGoal[]>{
    return this.http.get<IGoal[]>(this.baseUrl+'/findAll');
  }
  public getGoal(id: number):Observable<IGoal>{
    return this.http.get<IGoal>(this.baseUrl + '/findById/' + id);
  }
  public updateGoal(goal: IGoal):Observable<IGoal>{
    return this.http.put<IGoal>(this.baseUrl + '/update/' + goal.id, goal);
  }
  public addMoneyToGoal(goal: IGoal):Observable<IGoal>{
    return this.http.put<IGoal>(this.baseUrl + '/addMoney/' + goal.id, goal);
  }
  public addGoal(goal: IGoal):Observable<IGoal>{
    return this.http.post<IGoal>(this.baseUrl + '/addGoal', goal);
  }
  public addGoals(goals: IGoal[]):Observable<IGoal[]>{
    return this.http.post<IGoal[]>(this.baseUrl + '/addGoals', goals);
  }
  public deleteGoal(goal: IGoal):Observable<IGoal>{
    return this.http.delete<IGoal>(this.baseUrl + '/delete/' + goal.id);
  }
}
