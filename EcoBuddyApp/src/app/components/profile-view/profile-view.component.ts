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
    new Task(1, "Wyrzuc smiecia", EPriority.HIGH, EStatus.TODO),
    new Task(2, "Zabij kogos kto smieci", EPriority.MEDIUM, EStatus.IN_PROGRESS),
    new Task(3, "Zatrzymaj topnienie lodowca", EPriority.LOW, EStatus.DONE),
  ]
  ngOnInit(): void {

  }
}
