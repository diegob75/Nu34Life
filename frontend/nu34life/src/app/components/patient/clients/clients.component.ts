import { Component, OnInit } from '@angular/core';
import {Patient} from '../../../model/patient';
import {ApiService} from '../../../service/api.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {

  patients: Patient[];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    const id = 0;

    this.apiService.getAffiliatedPatients(id).subscribe(res => {
      this.patients = res;
    }, err => {
      console.log(err);
    });
  }

}
