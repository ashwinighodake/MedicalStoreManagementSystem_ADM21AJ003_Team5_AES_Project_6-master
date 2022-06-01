import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineSalestoCustomerComponent } from './medicine-salesto-customer.component';

describe('MedicineSalestoCustomerComponent', () => {
  let component: MedicineSalestoCustomerComponent;
  let fixture: ComponentFixture<MedicineSalestoCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedicineSalestoCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineSalestoCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
