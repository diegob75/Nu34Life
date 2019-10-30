import { Component, OnInit, Input } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class FoodAddComponent implements OnInit {

  @Input() foodData = { name:'' };

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addProduct() {
    this.rest.addFood(this.foodData).subscribe((result) => {
      this.router.navigate(['/foods/']);
    }, (err) => {
      console.log(err);
    });
  }

}