import {Component, Inject, Input, OnInit} from '@angular/core';
import {Recipe} from '../../../model/recipe';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {
  private recipe: Recipe;

  constructor(@Inject(MAT_DIALOG_DATA) public data: Recipe) {
    this.recipe = data;
  }

  ngOnInit() {
  }

}
