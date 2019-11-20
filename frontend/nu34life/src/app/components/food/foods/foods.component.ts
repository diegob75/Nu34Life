import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { of } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { Food } from '../../../model/food';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { getResource } from '../../../service/aws.service';
import { ApiService } from '../../../service/api.service';
import { merge, Observable } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { Page } from '../../../shared/page';
@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.scss']
})

export class FoodsComponent implements AfterViewInit {

  columns = ['image', 'name', 'energeticValue', 'totalFat', 'carbohydrates', 'sugars', 'protein', 'salt'];
  foods: Food[] = [];
  isLoadingResults = true;
  connectionError = false;
  resultLength = 0;

  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort: MatSort;

  constructor(private rest: ApiService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngAfterViewInit(): void {
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.rest.getFoods(null, this.sort.active, this.sort.direction, this.paginator.pageIndex,
            null);
        }),
        map((data: Page<Food>) => {
          console.log(data);

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
      ).subscribe((data: Food[]) => this.foods = data);
  }

  getPhoto(filename) {
    return getResource(filename);
  }

  get length(): number {
    return this.foods == null ? 0 : this.resultLength;
  }

  /*  delete(id) {
      this.rest.deleteProduct(id)
        .subscribe(res => {
            this.getProducts();
          }, (err) => {
            console.log(err);
          }
        );
    }*/

}
