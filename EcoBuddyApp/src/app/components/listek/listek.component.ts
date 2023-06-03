import {Component} from '@angular/core';
import {EType, Goal} from "../../shared/Goal";
import {Router} from "@angular/router";

@Component({
  selector: 'app-listek',
  templateUrl: './listek.component.html',
  styleUrls: ['./listek.component.css']
})
export class ListekComponent {
  constructor(private router: Router) {

  }
  goals: Goal[] =[
    new Goal(1, 'Pomoc osobom w trudnej sytuacji życiowej', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
    new Goal(2, 'Pomoc dzieciom z ubogich rodzin', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
    new Goal(3, 'Pomoc osobom niepełnosprawnym', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
    new Goal(4, 'Pomoc osobom w trudnej sytuacji życiowej', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
    new Goal(5, 'Pomoc osobom w trudnej sytuacji życiowej', 'Warszawa', EType.SOCIAL, 0, 10000, 'Fundacja "Dla dzieci"', 'Cel i misja: Pomoc dzieciom z ubogich rodzin.'),
  ]
  selectedGoal: Goal = this.goals[Math.floor(Math.random() * this.goals.length)];
  shoudModalBeActive: boolean = false;
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
}
