import { Component, OnInit } from '@angular/core';
import { CustomerDetails } from '../customer-details';
import { CustomerServiceService } from '../customer-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  id: number;
  customer: CustomerDetails = new CustomerDetails();
  constructor(private service: CustomerServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getCustomerListById(this.id).subscribe(data => {
      this.customer = data
    }, error => console.log(error));
  }

  goToCustomerList() {
    this.router.navigate(['/customer'])
  }

  onSubmit() {
    this.service.updateCustomer(this.id, this.customer).subscribe(data => {
      this.goToCustomerList();
    }, error => console.log(error));
  }

}
