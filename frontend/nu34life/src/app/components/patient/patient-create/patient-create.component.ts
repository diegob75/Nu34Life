import { Component, OnInit } from '@angular/core';
import {Patient} from '../../../model/patient';

@Component({
  selector: 'app-patient-create',
  templateUrl: './patient-create.component.html',
  styleUrls: ['./patient-create.component.scss']
})
export class PatientCreateComponent implements OnInit {

  patient: Patient;

  constructor() { }

  ngOnInit() {
  }

}
