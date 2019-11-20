import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {MatSort} from '@angular/material/sort';
import {Patient} from '../../../model/patient';
import {SelectionModel} from '@angular/cdk/collections';
import {ApiService} from '../../../service/api.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.scss']
})
export class PatientsComponent implements OnInit {

  // @ts-ignore
  patients: Patient[];
  columns = ['avatar', 'firstName', 'lastName', 'email'];
  dataSource: MatTableDataSource<Patient>;
  selection = new SelectionModel<Patient>(true, []);

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private apiService: ApiService,
              private dialog: MatDialog,
              private router: Router) { }

  ngOnInit() {
    this.dataSource = new MatTableDataSource<Patient>(this.patients);
    this.dataSource.sort = this.sort;
    this.apiService.getAllPatients().subscribe(res => {
      console.log(res);
      this.patients = res;
      this.dataSource = new MatTableDataSource<Patient>(this.patients);
    }, err => {

    });
  }

  affiliatePatient() {
    // const dialogRef = this.dialog.open(AffiliateComponent, {
    //   width: '300px'
    // });
    // dialogRef.afterClosed().subscribe(res => {
    //
    // });
    this.router.navigate(['/patients/create']);
  }

  get length(): number {
    return this.patients == null ? 0 : this.patients.length;
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  isAllSelected(): boolean {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.selection.select(row));
  }

  checkboxLabel(row?: Patient): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.id}`;
  }
}
