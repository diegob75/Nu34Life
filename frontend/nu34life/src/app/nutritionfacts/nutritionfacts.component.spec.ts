import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NutritionfactsComponent } from './nutritionfacts.component';

describe('NutritionfactsComponent', () => {
  let component: NutritionfactsComponent;
  let fixture: ComponentFixture<NutritionfactsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NutritionfactsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NutritionfactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
