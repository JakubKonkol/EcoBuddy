enum EventType {
  ENVIRONMENT,
  HEALTHCARE,
  SOCIAL
}

export interface IGoal{
  id: number;
  name: string;
  city: string;
  type: EventType
  moneyCollected: number;
  moneyNeeded: number;
  foundationName: string;
  description: string;
}
