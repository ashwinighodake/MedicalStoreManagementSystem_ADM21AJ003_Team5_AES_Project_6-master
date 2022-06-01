import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { CustomerAuthenticationService } from './customer-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {
  constructor(private router: Router,
    private authService: AuthenticationService,
    private service: CustomerAuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.authService.isUserLoggedIn()) {
      return true;
    }
    else if(this.service.isCustomerLoggedIn()){
      this.router.navigate(['customerHome']);
    }
    else {
      this.router.navigate(['home']);
    }
  }

}
