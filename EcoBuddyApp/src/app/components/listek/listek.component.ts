import {Component, OnInit} from '@angular/core';
import {EType, Goal} from "../../shared/Goal";
import {Router} from "@angular/router";
import {GoalService} from "../../services/goal.service";
import {IGoal} from "../../shared/IGoal";
import {GoalHistoryService} from "../../services/goalHistory.service";

@Component({
  selector: 'app-listek',
  templateUrl: './listek.component.html',
  styleUrls: ['./listek.component.css']
})
export class ListekComponent implements OnInit{
  userSelectedGoal: boolean = false;
  constructor(private router: Router, private goalService: GoalService, private goalHistoryService: GoalHistoryService) {

  }
  // goals: Goal[] =[
  //   new Goal(1, 'Pomoc osobom w trudnej sytuacji życiowej', 'Warszawa', EType.SOCIAL, 3000, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
  //   new Goal(2, 'Pomoc dzieciom z ubogich rodzin', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
  //   new Goal(3, 'Pomoc osobom niepełnosprawnym', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
  //   new Goal(4, 'Pomoc osobom w trudnej sytuacji życiowej', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
  //   new Goal(5, 'Pomoc osobom w trudnej sytuacji życiowej', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
  // ]
  goals: IGoal[] = [];
  selectedGoal: IGoal = this.goals[Math.floor(Math.random() * this.goals.length)];
  shoudModalBeActive: boolean = false;
  userSupported: boolean = false;
  liscState: string = 'assets/listek_fixed.png';
  goto(url:string){
    this.router.navigateByUrl(url).then(r => console.log(r));
  }
  changeGoal(){
    this.shoudModalBeActive = true;
  }

  closeModal() {
    this.shoudModalBeActive = false;
  }

  getLiscState() {
    return this.liscState;
  }

  setLiscState(arg: string) {
    switch (arg){
      case 'clicked':
        this.liscState = 'assets/listek_clicked_fixed.png';
        break;
      case 'default':
        this.liscState = 'assets/listek_fixed.png';

    }
  }

  setGoal($event: IGoal) {
    this.selectedGoal = $event;
    this.userSelectedGoal = true;
    this.shoudModalBeActive = false;
  }

  closeSupportedModal() {
    this.userSupported = false;
  }

  supportGoal() {
    let id = this.selectedGoal.id;
    this.goalHistoryService.addGoalToHistory(this.selectedGoal);
    //req /goals/id/add-money  TODO
    this.userSupported = true;
    this.goalService.addMoneyToGoal(this.selectedGoal).subscribe(data => {
      console.log(data);
    });
    this.goalService.getGoals().subscribe(data => {
      this.goals = data;
      this.selectedGoal = this.goals[Math.floor(Math.random() * this.goals.length)];
    });


  }

  ngOnInit(): void {
    this.goalService.getGoals().subscribe(data => {
      this.goals = data;
      this.selectedGoal = this.goals[Math.floor(Math.random() * this.goals.length)];
    });
  }
}
