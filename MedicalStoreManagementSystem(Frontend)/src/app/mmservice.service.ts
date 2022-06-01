import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineDetails } from './medicine-details';

@Injectable({
  providedIn: 'root'
})
export class MMServiceService {

  baseurl = "http://localhost:8998/msms/v1/medicines";
  constructor(private httpClient: HttpClient) { }

  getMedicineList(): Observable<MedicineDetails[]> {
    return this.httpClient.get<MedicineDetails[]>(`${this.baseurl}`);
  }

  createMedicine(medicine: MedicineDetails): Observable<Object> {
    return this.httpClient.post(`${this.baseurl}`, medicine);
  }

  getMedicineListById(id: number): Observable<MedicineDetails> {
    return this.httpClient.get<MedicineDetails>(`${this.baseurl}/${id}`);
  }

  updateMedicine(id: number, medicine: MedicineDetails): Observable<Object> {
    return this.httpClient.put(`${this.baseurl}/${id}`, medicine);
  }

  deleteMedicine(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseurl}/${id}`);
  }

  getMedicineToOrder(): Observable<MedicineDetails[]> {
    return this.httpClient.get<MedicineDetails[]>(`${this.baseurl}` + '/order');
  }
}
