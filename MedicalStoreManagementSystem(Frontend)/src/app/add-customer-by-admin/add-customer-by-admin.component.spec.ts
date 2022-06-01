import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCustomerByAdminComponent } from './add-customer-by-admin.component';

describe('AddCustomerByAdminComponent', () => {
  let component: AddCustomerByAdminComponent;
  let fixture: ComponentFixture<AddCustomerByAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCustomerByAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCustomerByAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
