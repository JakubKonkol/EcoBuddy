import {Component} from '@angular/core';
import {Task} from 'src/app/shared/Task';
import {EPriority} from "../../shared/EPriority";
import {EStatus} from "../../shared/EStatus";

@Component({
  selector: 'app-buddy-view',
  templateUrl: './buddy-view.component.html',
  styleUrls: ['./buddy-view.component.css']
})
export class BuddyViewComponent {
  tasks: Task[] = [
    new Task(1, "Task 1", EPriority.HIGH, EStatus.TODO),
    new Task(2, "Task 2", EPriority.MEDIUM, EStatus.IN_PROGRESS),
    new Task(3, "Task 3", EPriority.LOW, EStatus.DONE)
  ]

}
