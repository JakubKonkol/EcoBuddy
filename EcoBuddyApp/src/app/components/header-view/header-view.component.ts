import { Component, Input} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-view',
  templateUrl: './header-view.component.html',
  styleUrls: ['./header-view.component.css']
})
export class HeaderViewComponent {
  @Input() name: any;
  constructor(private router: Router) {}
  goto(url: string){
    this.router.navigate([url]).then(r => console.log(r));
  }
}
