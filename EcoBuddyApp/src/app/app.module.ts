import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BuddyViewComponent } from './components/buddy-view/buddy-view.component';
import { HeaderViewComponent } from './components/header-view/header-view.component';
import { SingleTaskViewComponent } from './components/single-task-view/single-task-view.component';
import { DashboardViewComponent } from './components/dashboard-view/dashboard-view.component';
import { EcoHomeViewComponent } from './components/eco-home-view/eco-home-view.component';
import { SingleDeviceViewComponent } from './components/single-device-view/single-device-view.component';
import { EcoHomeResultViewComponent } from './components/eco-home-result-view/eco-home-result-view.component';
import { ListekComponent } from './components/listek/listek.component';
import { RouterModule, Routes } from '@angular/router';
import { MainBuddyViewComponent } from './components/main-buddy-view/main-buddy-view.component';
import { FundationViewComponent } from './components/fundation-view/fundation-view.component';
import { GoalSupportedModalComponent } from './components/goal-supported-modal/goal-supported-modal.component';
import { EventsViewComponent } from './components/events-view/events-view.component'
import {HttpClientModule} from "@angular/common/http";
import { ProfileViewComponent } from './components/profile-view/profile-view.component';
import {GoalHistoryService} from "./services/goalHistory.service";
import {GoalService} from "./services/goal.service";

@NgModule({
  declarations: [
    AppComponent,
    BuddyViewComponent,
    HeaderViewComponent,
    SingleTaskViewComponent,
    DashboardViewComponent,
    EcoHomeViewComponent,
    SingleDeviceViewComponent,
    EcoHomeResultViewComponent,
    ListekComponent,
    MainBuddyViewComponent,
    FundationViewComponent,
    GoalSupportedModalComponent,
    EventsViewComponent,
    ProfileViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    GoalHistoryService,
    GoalService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
