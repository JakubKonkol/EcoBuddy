import {Component, Input} from '@angular/core';
import {Device} from "../../shared/Device";

@Component({
  selector: 'app-single-device-view',
  templateUrl: './single-device-view.component.html',
  styleUrls: ['./single-device-view.component.css']
})
export class SingleDeviceViewComponent {
  @Input() device!: Device;

}
