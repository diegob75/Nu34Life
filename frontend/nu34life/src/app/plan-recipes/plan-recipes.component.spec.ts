import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanRecipesComponent } from './plan-recipes.component';

describe('PlanRecipesComponent', () => {
  let component: PlanRecipesComponent;
  let fixture: ComponentFixture<PlanRecipesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanRecipesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanRecipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
