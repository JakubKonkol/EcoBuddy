enum EventType {
  ENVIRONMENT,
  HEALTHCARE,
  SOCIAL
}

export interface IGoal{
  idGoal: number;
  name: string;
  city: string;
  type: EventType
  moneyCollected: number;
  moneyNeeded: number;
  foundationName: string;
  description: string;
}
