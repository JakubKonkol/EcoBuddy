import {Component, OnInit} from '@angular/core';
import {GoalHistoryService} from "../../services/goalHistory.service";
import {Task} from "../../shared/Task";
import {EPriority} from "../../shared/EPriority";
import {EStatus} from "../../shared/EStatus";

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.css']
})
export class ProfileViewComponent implements OnInit{
  constructor(private goalHistoryService: GoalHistoryService) {
  }
  goalHistory = this.goalHistoryService.goalHistory;
  tasks: Task[] = [
    new Task(1, "Task 2", EPriority.HIGH, EStatus.TODO),
    new Task(2, "Task 3", EPriority.MEDIUM, EStatus.IN_PROGRESS),
    new Task(3, "Task 4", EPriority.LOW, EStatus.DONE),
  ]
  ngOnInit(): void {

  }
}
