import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort, MatTableDataSource} from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';
import {Recipe} from '../../../model/recipe';
import {ApiService} from '../../../shared/api.service';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-recipes2',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class Recipes2Component implements OnInit {

  recipes: Recipe[] = [];
  expandedElement: Recipe | null;
  columns = [ 'select', 'image', 'name', 'servings', 'actions'];
  dataSource: MatTableDataSource<Recipe>;
  selection = new SelectionModel<Recipe>(true, []);

  get expanded(): boolean {
    return this.expandedElement != null;
  }

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.dataSource = new MatTableDataSource<Recipe>([]);
    this.apiService.getAllRecipes().subscribe(res => {
      this.recipes = res;
      this.dataSource = new MatTableDataSource<Recipe>(this.recipes);
      this.dataSource.sort = this.sort;
    }, err => {
      console.log(err);
    });
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

  checkboxLabel(row?: Recipe): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.id}`;
  }
}
