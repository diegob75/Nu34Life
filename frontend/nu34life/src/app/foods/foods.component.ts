import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';
import {Food} from '../model/food';
@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})

export class FoodsComponent implements OnInit {

  foods: Food[] = [];

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getFoods();
  }

  getFoods() {
    this.foods = [];
    this.rest.getFoods().subscribe((data: {}) => {
      console.log(data);
      this.foods = data as Food[];
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
