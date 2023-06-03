import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Goal} from "../../shared/Goal";

@Component({
  selector: 'app-fundation-view',
  templateUrl: './fundation-view.component.html',
  styleUrls: ['./fundation-view.component.css']
})
export class FundationViewComponent {
  @Input() goals!: Goal[];
  @Output() closeSignal = new EventEmitter<void>();
  emitClose() {
    this.closeSignal.emit();
  }
}
