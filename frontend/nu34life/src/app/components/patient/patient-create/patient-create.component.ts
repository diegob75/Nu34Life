import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { ApiService } from '../../../service/api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-patient-create',
  templateUrl: './patient-create.component.html',
  styleUrls: ['./patient-create.component.scss']
})
export class PatientCreateComponent implements OnInit {

  username:string;
  password:string;
  email:string;
  firstName:string;
  lastName:string;
  weight:number;
  height:number;


  constructor(private rest: ApiService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
  }

  registrarPaciente(){
    let patient = new User();
    patient.email = this.email;
    patient.firstName = this.firstName;
    patient.lastName = this.lastName;
    patient.height = this.height;
    patient.weight = this.weight;
    patient.username = this.username;
    patient.password = this.password;
    console.log(patient);

    this.rest.createPatient(patient).subscribe(p => {
      this.router.navigate(['/patients']);
    }, err => {
      this.router.navigate(['/patients']);
      console.error('Código del error desde el backend: ' + err.status);
    });
  }
}