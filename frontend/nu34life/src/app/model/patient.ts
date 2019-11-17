import {User} from './user';

export interface Patient {
  id: number;
  userId: number;
  firstName: string;
  lastName: string;
  email: string;
  image: string;
}
