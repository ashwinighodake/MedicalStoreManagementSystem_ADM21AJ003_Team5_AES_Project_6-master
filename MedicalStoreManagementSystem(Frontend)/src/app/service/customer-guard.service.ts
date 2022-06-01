import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { CustomerAuthenticationService } from './customer-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerGuardService implements CanActivate {
  constructor(private router: Router,
    private authService : AuthenticationService,
    private service: CustomerAuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.service.isCustomerLoggedIn()) {
      return true;
    }
    else if(this.authService.isUserLoggedIn()){
      this.router.navigate(['adminHome'])
    }
    else {
      this.router.navigate(['home']);
      return false;
    }
  }

}
