import {MockResources} from '../mock-resources';
import {Patient} from '../../model/patient';

export const patientDb: Patient[] = [
  { id: 1, email: 'patient1@gmail.com', firstName: 'patient', lastName: 'one', userId: 1, image: MockResources.avatar() },
  { id: 2, email: 'patient2@gmail.com', firstName: 'patient', lastName: 'two', userId: 2, image: MockResources.avatar() }
];
