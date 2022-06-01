import { Injectable } from '@angular/core';
import { CustomerDetails } from '../customer-details';
import { CustomerServiceService } from '../customer-service.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerAuthenticationService {

  data1: Boolean;
  customer: CustomerDetails = new CustomerDetails();
  constructor(private service: CustomerServiceService) { }

  isCustomerLoggedIn() {
    let customerUser = sessionStorage.getItem('phone')
    return !(customerUser == null)
  }

  customerLogout() {
    sessionStorage.removeItem('phone');
  }

}
