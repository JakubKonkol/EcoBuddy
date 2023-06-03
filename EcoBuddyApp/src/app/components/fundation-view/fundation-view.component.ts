import {Component, EventEmitter, Input, OnInit, Output, Renderer2} from '@angular/core';
import {Goal} from "../../shared/Goal";

@Component({
  selector: 'app-fundation-view',
  templateUrl: './fundation-view.component.html',
  styleUrls: ['./fundation-view.component.css']
})
export class FundationViewComponent implements OnInit{
  @Input() goals!: Goal[];
  @Output() closeSignal = new EventEmitter<void>();
  @Output() goalSignal = new EventEmitter<Goal>();
  ngOnInit(): void {

  }
  emitClose() {
    this.closeSignal.emit();
  }

  setGoal(goal: Goal) {
    this.goalSignal.emit(goal);
  }

  random():string {
    let random = Math.floor(Math.random() * 100) + 1
    return `${random}%`;
  }
}
