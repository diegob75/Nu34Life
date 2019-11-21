import {Account} from './account';

export class User extends Account {
  firstName: string;
  lastName: string;
  profileId: number;
  imagen: string;
  height: number;
  weight: number;
  userId: number;
}
