import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerRegistrationLoginComponent } from './customer-registration-login.component';

describe('CustomerRegistrationLoginComponent', () => {
  let component: CustomerRegistrationLoginComponent;
  let fixture: ComponentFixture<CustomerRegistrationLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerRegistrationLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerRegistrationLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
