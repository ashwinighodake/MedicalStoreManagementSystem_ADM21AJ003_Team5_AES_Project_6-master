import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseurl = "http://localhost:8998/msms/v1/admin";
  constructor(private httpClient: HttpClient) { }

  getAdminList(): Observable<Admin[]> {
    return this.httpClient.get<Admin[]>(`${this.baseurl}`);
  }

  createAdmin(admin: Admin): Observable<object> {
    return this.httpClient.post(`${this.baseurl}`, admin);
  }

  getAdminByUsername(username: string): Observable<Admin> {
    return this.httpClient.get<Admin>(`${this.baseurl}/` + username);
  }
}
