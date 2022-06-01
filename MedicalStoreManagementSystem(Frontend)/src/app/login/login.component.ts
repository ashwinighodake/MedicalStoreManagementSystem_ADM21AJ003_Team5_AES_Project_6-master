import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  validUsername: string;
  validPassword: string;
  error: String;
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private service: AdminService) { }

  ngOnInit() {
  }

  checkLogin() {
    this.service.getAdminByUsername(this.username).subscribe(data => {
      this.validUsername = data.username;
      this.validPassword = data.password;
      console.log(this.username === this.validUsername && this.password === this.validPassword);
      if (this.username === this.validUsername && this.password === this.validPassword) {
        sessionStorage.setItem('username', this.username);
        this.router.navigate(['adminHome']);
      }
      else {
        this.error = "Invalid username and password";
      }
    })
  }
}
