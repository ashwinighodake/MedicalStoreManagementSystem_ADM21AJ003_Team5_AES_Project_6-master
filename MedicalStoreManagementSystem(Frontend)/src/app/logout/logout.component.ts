import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { CustomerAuthenticationService } from '../service/customer-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private authenticationService: AuthenticationService,
    private authentication: CustomerAuthenticationService,
    private router: Router) {

  }

  ngOnInit() {
    this.authenticationService.logOut();
    this.authentication.customerLogout();
    this.router.navigate(['home']);
  }

}