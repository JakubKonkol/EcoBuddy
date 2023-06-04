import {Component, EventEmitter, Input, OnInit, Output, Renderer2} from '@angular/core';
import {Goal} from "../../shared/Goal";
import {IGoal} from "../../shared/IGoal";

@Component({
  selector: 'app-fundation-view',
  templateUrl: './fundation-view.component.html',
  styleUrls: ['./fundation-view.component.css']
})
export class FundationViewComponent implements OnInit{
  @Input() goals!: IGoal[];
  @Output() closeSignal = new EventEmitter<void>();
  @Output() goalSignal = new EventEmitter<IGoal>();
  ngOnInit(): void {

  }
  emitClose() {
    this.closeSignal.emit();
  }

  setGoal(goal: IGoal) {
    this.goalSignal.emit(goal);
  }

  getRandomOffset():string {
    let random = Math.floor(Math.random() * 100) + 1
    return `${random}%`;
  }
}
