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
    new Task(1, "Zorganizuj 15-minutowy lokalny spacer w celu zebrania śmieci z ulic", EPriority.HIGH, EStatus.TODO),
    new Task(2, "Zamień żarówki na energooszczędne w swoim domu", EPriority.MEDIUM, EStatus.IN_PROGRESS),
    new Task(3, "Zbierz plastikowe nakrętki i przekaż je na cele charytatywne", EPriority.LOW, EStatus.DONE),
  ]
  ngOnInit(): void {

  }
}
