import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Sales } from '../sales';
import { SalesServiceService } from '../sales-service.service';
import { MedicineDetails } from '../medicine-details';
import { MMServiceService } from '../mmservice.service';

@Component({
  selector: 'app-medicine-salesto-customer',
  templateUrl: './medicine-salesto-customer.component.html',
  styleUrls: ['./medicine-salesto-customer.component.css']
})
export class MedicineSalestoCustomerComponent implements OnInit {
  error: boolean = false;
  sales: Sales = new Sales();
  medicine: MedicineDetails = new MedicineDetails();
  amt: number;
  amt1: number = 0;
  listData: any;
  listAmount: any;
  userForm: FormGroup;
  totalAmount: FormGroup;
  constructor(private salesService: SalesServiceService,
    private service: MMServiceService,
    private router: Router,
    private fb: FormBuilder) {
    this.listData = [];
    this.userForm = this.fb.group({
      mName: ['', Validators.required],
      quantity: ['', Validators.required],
      amount: ['', Validators.required]
    });
    this.listAmount = [];
    this.totalAmount = this.fb.group({
      netAmount: ['', Validators.required]
    })

  }
  ngOnInit(): void {
  }
  saveMedicine() {
    this.salesService.createSales(this.sales).subscribe(data => {
      this.service.getMedicineListById(this.sales.medicineId).subscribe(data1 => {
        this.amt = ((data1.price) * (this.sales.quantity))
        console.log(this.amt);
        this.amt1 += this.amt;
        console.log(this.amt1);
        this.userForm.setValue({
          mName: data1.name,
          quantity: this.sales.quantity,
          amount: ((data1.price) * (this.sales.quantity))
        }),

          this.totalAmount.setValue({
            netAmount: this.amt1
          }),
          this.listData.push(this.userForm.value)
      })
    },
      error => this.error = true);
  }
  goToSalesList() {
    this.router.navigate(['/medicine'])
  }
  onSubmit() {
    console.log(this.sales);
    this.saveMedicine();
  }
}