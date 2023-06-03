import {Device} from "./Device";
import deviceList from "./deviceList.json";

export class DeviceLoader{
  devices: Device[] = [];
  constructor() {
    this.loadDevices();
  }
  loadDevices() {
    for (let device of deviceList){
      this.devices.push(new Device(
        device.nazwa,
        device.pobor_mocy/1000
      ));
    }
  }
}
