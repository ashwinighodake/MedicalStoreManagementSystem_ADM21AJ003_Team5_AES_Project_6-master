import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderToBePlacedComponent } from './order-to-be-placed.component';

describe('OrderToBePlacedComponent', () => {
  let component: OrderToBePlacedComponent;
  let fixture: ComponentFixture<OrderToBePlacedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderToBePlacedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderToBePlacedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
