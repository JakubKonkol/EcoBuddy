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
    new Task(1, "Zbierz 5 butelek", EPriority.LOW, EStatus.TODO),
    new Task(2, "Wyrzuc smieci za sasiada", EPriority.MEDIUM, EStatus.IN_PROGRESS),
    new Task(3, "Posprzataj ocean", EPriority.HIGH, EStatus.DONE)
  ]

}
