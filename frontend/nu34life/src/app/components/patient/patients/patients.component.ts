import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatTableDataSource} from '@angular/material';
import {MatSort} from '@angular/material/sort';
import {Patient} from '../../../model/patient';
import {SelectionModel} from '@angular/cdk/collections';
import {ApiService} from '../../../service/api.service';
import {Router} from '@angular/router';
import {merge, of} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import {Page} from '../../../shared/page';
import {Recipe} from '../../../model/recipe';
import {OauthService} from '../../../service/oauth.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.scss']
})
export class PatientsComponent implements AfterViewInit {

  nutritionistId: number;
  patients: Patient[];
  columns = ['avatar', 'firstName', 'lastName', 'email', 'action'];
  isLoadingResults = true;
  connectionError = false;
  resultLength = 0;

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;

  constructor(private apiService: ApiService,
              private authService: OauthService,
              private dialog: MatDialog,
              private router: Router) {
    this.nutritionistId = authService.profileId;
  }

  ngAfterViewInit() {
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.apiService.getAllPatients(null, this.sort.active, this.sort.direction, this.paginator.pageIndex,
            this.paginator.pageSize);
        }),
        map((data: Page<Patient>) => {
          this.isLoadingResults = false;
          this.connectionError = false;
          this.resultLength = data.totalElements;

          return data.content;
        }),
        catchError(() => {
          this.isLoadingResults = false;
          this.connectionError = true;
          return of([]);
        })
      ).subscribe((data: Patient[]) => {
      console.log(data);
      this.patients = data;
    });
  }

  requestAffiliation(patient: Patient) {
    this.apiService.requestAffiliation(patient.id, this.nutritionistId).subscribe(res => {
      console.log(res);
    }, err => {
      console.log(err);
    });
  }
}
