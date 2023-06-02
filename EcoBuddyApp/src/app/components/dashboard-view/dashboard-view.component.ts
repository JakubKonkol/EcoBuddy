import { Component } from '@angular/core';
@Component({
  selector: 'app-dashboard-view',
  templateUrl: './dashboard-view.component.html',
  styleUrls: ['./dashboard-view.component.css']
})
export class DashboardViewComponent {
    viewState = 'ECOHOME'; //SHOULD BE DEFAULT

  setViewState(arg: string) {
    this.viewState = arg;
  }
}
