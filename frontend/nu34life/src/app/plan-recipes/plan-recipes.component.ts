import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-plan-recipes',
  templateUrl: './plan-recipes.component.html',
  styleUrls: ['./plan-recipes.component.css']
})
export class PlanRecipesComponent implements OnInit {

  planRecipes:any = [];

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getPlanRecipes();
  }

  getPlanRecipes() {
    this.planRecipes = [];
    this.rest.getPlanRecipes().subscribe((data: {}) => {
      console.log(data);
      this.planRecipes = data;
    });
  }
/*
  add() {
    this.router.navigate(['/product-add']);
  }


  delete(id) {
    this.rest.deleteProduct(id)
      .subscribe(res => {
          this.getProducts();
        }, (err) => {
          console.log(err);
        }
      );
  }*/

}
