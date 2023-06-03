import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-eco-home-result-view',
  templateUrl: './eco-home-result-view.component.html',
  styleUrls: ['./eco-home-result-view.component.css']
})
export class EcoHomeResultViewComponent {
  @Input() userPowerUsage!: number ;
}
