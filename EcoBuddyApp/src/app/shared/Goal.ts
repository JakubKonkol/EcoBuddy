export enum EType {
  SOCIAL = 'social',
  ENVIROMENT = 'enviroment',
  HEALTH = 'health care',
}

export class Goal{
  id: number;
  name: string;
  city: string;
  typ: EType;
  collectedAmount: number;
  targetAmount: number;
  fundation: string;
  description: string;

  constructor(id: number, name: string, miasto: string, typ: EType, collectedAmount: number, targetAmount: number, fundation: string, description: string) {
    this.id = id;
    this.name = name;
    this.city = miasto;
    this.typ = typ;
    this.collectedAmount = collectedAmount;
    this.targetAmount = targetAmount;
    this.fundation = fundation;
    this.description = description;
  }
}
