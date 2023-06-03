export class Device{
  name: string;
  powerUsage: number;
  img: string;

  constructor(name: string, powerUsage: number, img: string){
    this.name = name;
    this.powerUsage = powerUsage;
    this.img = img;
  }
}
