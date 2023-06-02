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
  yourDevices: Device[] = [];
  shouldModalBeActive: boolean = false;
  selectedDevice: Device | undefined;
  ngOnInit(): void {
    this.devices = new DeviceLoader().devices;
  }

  selectDevice(device: Device) {
    this.selectedDevice = device;
    this.shouldModalBeActive = true;
  }
  addDevice() {
    if(this.selectedDevice === undefined) return;
    this.yourDevices.push(this.selectedDevice);
    this.selectedDevice = undefined;
    this.shouldModalBeActive = false;


  }

  removeDevice(device: Device) {
    this.yourDevices.splice(this.yourDevices.indexOf(device), 1);
  }
}
