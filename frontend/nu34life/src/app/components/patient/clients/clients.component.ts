import {Component, Input, OnInit} from '@angular/core';
import {Patient} from '../../../model/patient';
import {ApiService} from '../../../service/api.service';
import {getResource} from '../../../service/aws.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  patients: Patient[] = [];
  @Input() toggle: any;

  ngOnInit() {
    const id = 0;

    this.apiService.getAffiliatedPatients(id).subscribe(res => {
      this.patients = res;
    }, err => {
      console.log(err);
    });
  }

  getAvatar(file) {
    return getResource(file);
  }

}
