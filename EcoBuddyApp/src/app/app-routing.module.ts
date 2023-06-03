import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListekComponent} from "./components/listek/listek.component";
import {AppComponent} from "./app.component";
import {MainBuddyViewComponent} from "./components/main-buddy-view/main-buddy-view.component";

const routes: Routes = [
  {path:'', redirectTo: 'listek', pathMatch: 'full'},
  {path: 'listek', component: ListekComponent},
  {path: 'buddy', component: MainBuddyViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
