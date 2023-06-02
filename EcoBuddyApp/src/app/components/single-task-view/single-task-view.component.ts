import {Component, Input} from '@angular/core';
import {Task} from "../../shared/Task";
import {EPriority} from "../../shared/EPriority";

@Component({
  selector: 'app-single-task-view',
  templateUrl: './single-task-view.component.html',
  styleUrls: ['./single-task-view.component.css']
})
export class SingleTaskViewComponent {
  @Input() task!: Task;

  getClassForTask(task: Task): string {
    switch (task.priority) {
      case EPriority.LOW:
        return "low";
      case EPriority.MEDIUM:
        return "medium";
      case EPriority.HIGH:
        return "high";
    }
  }
}
