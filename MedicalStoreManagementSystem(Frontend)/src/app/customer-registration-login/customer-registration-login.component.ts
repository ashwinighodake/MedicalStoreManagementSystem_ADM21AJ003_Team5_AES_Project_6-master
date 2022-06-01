import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDetails } from '../customer-details';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-customer-registration-login',
  templateUrl: './customer-registration-login.component.html',
  styleUrls: ['./customer-registration-login.component.css']
})
export class CustomerRegistrationLoginComponent implements OnInit {

  username: '';
  password: '';
  validUsername:String;
  validPassword:String;
  error:String;
  invalidLogin = false;
  customer:CustomerDetails = new CustomerDetails();
  constructor(private router: Router, private service:CustomerServiceService) { }

  ngOnInit() {
  }

  checkLogin() {
    this.service.getCustomerByUsername(this.username).subscribe(data =>{
      this.validUsername =data.username;
      this.validPassword=data.password;
      console.log(this.username === this.validUsername && this.password === this.validPassword);
      if(this.username === this.validUsername && this.password === this.validPassword){
        sessionStorage.setItem('phone',data.phone);
        this.router.navigate(['customerHome']);
      }
      else{
        this.error="Invalid username and password";
      }
    })
  }

}