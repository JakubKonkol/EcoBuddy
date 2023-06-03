import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-goal-supported-modal',
  templateUrl: './goal-supported-modal.component.html',
  styleUrls: ['./goal-supported-modal.component.css']
})
export class GoalSupportedModalComponent {
  @Output() closeSignal = new EventEmitter<void>();

  closeModal() {
    this.closeSignal.emit();
  }
}
