import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { of } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {getResource} from '../../../service/aws.service';
import {ApiService} from '../../../service/api.service';
import {merge, Observable} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import {Page} from '../../../shared/page';
import {Recipe} from '../../../model/recipe';
import {ModalComponent} from '../dish/modal/modal.component';


@Component({
  selector: 'app-recipes2',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.scss'],
})
export class Recipes2Component implements AfterViewInit {

  columns = ['image', 'name', 'servings', 'details'];
  recipes: Recipe[] = [];
  isLoadingResults = true;
  connectionError = false;
  resultLength = 0;

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;

  constructor(private rest: ApiService,
              private route: ActivatedRoute,
              private router: Router,
              private dialog: MatDialog) { }

  ngAfterViewInit(): void {
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.rest.getRecipes(null, this.sort.active, this.sort.direction, this.paginator.pageIndex,
            null, true);
        }),
        map((data: Page<Recipe>) => {
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
      ).subscribe((data: Recipe[]) => this.recipes = data);
  }

  getPhoto(filename) {
    return getResource(filename);
  }


  get length(): number {
    return this.recipes == null ? 0 : this.resultLength;
  }


  viewRecipeDetails(recipe): void {
    const dialogRef = this.dialog.open(ModalComponent, {
      width: '800px',
      panelClass: 'card-dialog',
      data: recipe
    });

    dialogRef.afterClosed().subscribe(result => {

    });
  }
}
