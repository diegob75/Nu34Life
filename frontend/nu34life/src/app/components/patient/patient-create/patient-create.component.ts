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

  patient: User;

  constructor(private rest: ApiService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
  }

  registrarPaciente(){
    this.rest.createPatient(this.patient).subscribe(p => {
      this.router.navigate(['/patients']);
    }, err => {
      console.error('Código del error desde el backend: ' + err.status);
    });
  }
}
