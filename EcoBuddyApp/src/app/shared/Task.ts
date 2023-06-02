import {EPriority} from "./EPriority";
import {EStatus} from "./EStatus";

export class Task{
  id: number;
  description: string;
  priority: EPriority;
  status: EStatus;

  constructor(id: number, description: string, priority: EPriority, status: EStatus) {
    this.id = id;
    this.description = description;
    this.priority = priority;
    this.status = status;
  }
}
