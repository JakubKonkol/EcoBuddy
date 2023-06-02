import {Component, OnInit} from '@angular/core';
import {DeviceLoader} from "../../shared/DeviceLoader";
import {Device} from "../../shared/Device";

@Component({
  selector: 'app-eco-home-view',
  templateUrl: './eco-home-view.component.html',
  styleUrls: ['./eco-home-view.component.css']
})
export class EcoHomeViewComponent implements OnInit{
  devices: Device[] = [];
  ngOnInit(): void {
    this.devices = new DeviceLoader().devices;
  }

}
