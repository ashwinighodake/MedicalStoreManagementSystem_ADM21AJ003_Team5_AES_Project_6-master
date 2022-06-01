import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { CustomerAuthenticationService } from '../service/customer-authentication.service';


@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(public loginService: AuthenticationService,
    public service: CustomerAuthenticationService) { }

  ngOnInit(): void {
  }

}
