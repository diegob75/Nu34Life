import {DietDetail} from './diet-detail';

export interface DietDay {
  id: number;
  day: number;
  details: DietDetail[];
}
