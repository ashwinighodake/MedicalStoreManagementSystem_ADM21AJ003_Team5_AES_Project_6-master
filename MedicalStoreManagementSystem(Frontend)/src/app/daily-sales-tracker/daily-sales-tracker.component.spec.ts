import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DailySalesTrackerComponent } from './daily-sales-tracker.component';

describe('DailySalesTrackerComponent', () => {
  let component: DailySalesTrackerComponent;
  let fixture: ComponentFixture<DailySalesTrackerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DailySalesTrackerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DailySalesTrackerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
