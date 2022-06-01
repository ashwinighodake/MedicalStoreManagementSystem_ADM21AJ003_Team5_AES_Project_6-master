import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDetails } from '../customer-details';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-view-customer-details',
  templateUrl: './view-customer-details.component.html',
  styleUrls: ['./view-customer-details.component.css']
})
export class ViewCustomerDetailsComponent implements OnInit {

  customerList: CustomerDetails[];
  customerName: String
  data: Array<any>
  totalRecords: number
  page: number = 1

  constructor(private service: CustomerServiceService,
    private router: Router) {
    this.data = new Array<any>()
  }

  ngOnInit(): void {
    this.getCustomer();
  }

  private getCustomer() {
    this.service.getCustomerList().subscribe(data => {
      console.log(data);
      this.customerList = data;
      this.data = data;
      this.totalRecords = this.customerList.length;
    });
  }

  updateCustomer(id: number) {
    this.router.navigate(['update-customer', id]);
  }

  deleteCustomer(id: number) {
    this.service.deleteCustomer(id).subscribe(data => {
      console.log(data);
      this.getCustomer();
    })
  }

  Search() {
    if (this.customerName != "") {
      this.customerList = this.customerList.filter(res => {
        return res.name.toLocaleLowerCase().match(this.customerName.toLocaleLowerCase());
      })
    }
    else if (this.customerName == "") {
      this.ngOnInit();
    }
  }
}
