import {Component, Input} from '@angular/core';
import {Task} from "../../shared/Task";

@Component({
  selector: 'app-single-task-view',
  templateUrl: './single-task-view.component.html',
  styleUrls: ['./single-task-view.component.css']
})
export class SingleTaskViewComponent {
  @Input() task!: Task;
}
