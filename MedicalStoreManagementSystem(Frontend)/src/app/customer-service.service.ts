import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{ CustomerDetails } from './customer-details';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  baseurl="http://localhost:8998/msms/v1/customers";
  
  constructor(private httpClient:HttpClient) { }

  getCustomerList(): Observable<CustomerDetails[]>{
    return this.httpClient.get<CustomerDetails[]>(`${this.baseurl}`);
  }

  createCustomer(customer:CustomerDetails): Observable<Object>{
    return this.httpClient.post(`${this.baseurl}`, customer);
  }

  getCustomerListById(id: number): Observable<CustomerDetails>{
    return this.httpClient.get<CustomerDetails>(`${this.baseurl}/${id}`);
  }
  
  updateCustomer(id: number, medicine:CustomerDetails): Observable<Object>{
    return this.httpClient.put(`${this.baseurl}/${id}`, medicine);
  }

  deleteCustomer(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseurl}/${id}`);
  }

  getCustomerByPhone(phone : string): Observable<CustomerDetails>{
    return this.httpClient.get<CustomerDetails>(`${this.baseurl}/`+'phone/' + phone);
  }

  getCustomerByUsername(username: String): Observable<CustomerDetails>{
    return this.httpClient.get<CustomerDetails>(`${this.baseurl}/`+'username/' + username);
  }

  getCustomerByUsernameAndPassword(customer:CustomerDetails):Observable<CustomerDetails>{
    return this.httpClient.post<CustomerDetails>(`${this.baseurl}/`+'login',customer);
  }
}
