import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-nutritionfacts',
  templateUrl: './nutritionfacts.component.html',
  styleUrls: ['./nutritionfacts.component.css']
})
export class NutritionFactsComponent implements OnInit {

  nutritionfacts:any = [];

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getNutritionFacts();
  }

  getNutritionFacts() {
    this.nutritionfacts = [];
    this.rest.getNutritionFacts().subscribe((data: {}) => {
      console.log(data);
      this.nutritionfacts = data;
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