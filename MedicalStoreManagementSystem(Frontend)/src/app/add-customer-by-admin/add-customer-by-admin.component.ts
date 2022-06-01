import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDetails } from '../customer-details';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-add-customer-by-admin',
  templateUrl: './add-customer-by-admin.component.html',
  styleUrls: ['./add-customer-by-admin.component.css']
})
export class AddCustomerByAdminComponent implements OnInit {

  error: boolean = false;
  customer: CustomerDetails = new CustomerDetails();
  constructor(private createService: CustomerServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveMedicine() {
    this.createService.createCustomer(this.customer).subscribe(data => {
      console.log(data);
      this.goToCustomerList();
    },
      error => this.error = true);
  }

  goToCustomerList() {
    this.router.navigate(['/customer'])
  }
  onSubmit() {
    console.log(this.customer);
    this.saveMedicine();
  }
}
