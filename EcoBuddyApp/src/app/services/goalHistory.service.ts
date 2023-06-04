import {Injectable} from "@angular/core";
import {IGoal} from "../shared/IGoal";

@Injectable({
  providedIn: 'root'
})
export class GoalHistoryService {
  public goalHistory: IGoal[] = [];

  public addGoalToHistory(goal: IGoal) {
    this.goalHistory.push(goal);
  }
  public getGoalHistory() {
    return this.goalHistory;
  }
}
