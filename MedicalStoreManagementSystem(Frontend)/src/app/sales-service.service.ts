import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sales } from './sales';

@Injectable({
  providedIn: 'root'
})
export class SalesServiceService {

  baseurl = "http://localhost:8998/msms/v1/sales";
  constructor(private httpClient: HttpClient) { }

  createSales(sales: Sales): Observable<Object> {
    return this.httpClient.post(`${this.baseurl}`, sales);
  }

  getDailySales(date: Date): Observable<Sales[]> {
    return this.httpClient.get<Sales[]>(`${this.baseurl}/${date}`);
  }
}
