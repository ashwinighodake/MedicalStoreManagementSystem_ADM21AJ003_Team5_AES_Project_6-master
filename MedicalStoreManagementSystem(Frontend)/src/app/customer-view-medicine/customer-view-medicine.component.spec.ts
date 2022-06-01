import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerViewMedicineComponent } from './customer-view-medicine.component';

describe('CustomerViewMedicineComponent', () => {
  let component: CustomerViewMedicineComponent;
  let fixture: ComponentFixture<CustomerViewMedicineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerViewMedicineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerViewMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
