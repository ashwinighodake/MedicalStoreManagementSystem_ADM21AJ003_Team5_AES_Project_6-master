import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {

  name: String;
  date: Date;
  constructor(private service: CustomerServiceService) {
    this.date = new Date();
  }

  ngOnInit(): void {
    this.service.getCustomerByPhone(sessionStorage.getItem('phone')).subscribe(data => {
      console.log(data.name);
      this.name = data.name;
    })
  }
}
