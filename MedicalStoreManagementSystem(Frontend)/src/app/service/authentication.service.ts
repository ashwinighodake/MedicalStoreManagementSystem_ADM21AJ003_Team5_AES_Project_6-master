import { Injectable } from '@angular/core';
import { CustomerDetails } from '../customer-details';
import { CustomerServiceService } from '../customer-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  customer: CustomerDetails = new CustomerDetails();
  constructor(private service: CustomerServiceService) { }

  authenticate(username, password) {
    if (username === "admin" && password === "admin@123") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}