import { Component, OnInit, Input } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.css']
})
export class RecipeAddComponent implements OnInit {

  @Input() recipeData = { name:'' };

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addRecipe() {
    this.rest.addRecipe(this.recipeData).subscribe((result) => {
      this.router.navigate(['/recipes/']);
    }, (err) => {
      console.log(err);
    });
  }

}