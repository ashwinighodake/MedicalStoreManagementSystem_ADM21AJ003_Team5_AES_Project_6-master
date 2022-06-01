import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MedicineDetails } from '../medicine-details';
import { MMServiceService } from '../mmservice.service';

@Component({
  selector: 'app-customer-view-medicine',
  templateUrl: './customer-view-medicine.component.html',
  styleUrls: ['./customer-view-medicine.component.css']
})
export class CustomerViewMedicineComponent implements OnInit {

  medicineList: MedicineDetails[];
  medicineName: String
  data: Array<any>
  totalRecords: number
  page: number = 1

  constructor(private service: MMServiceService,
    private router: Router) {
    this.data = new Array<any>()
  }

  ngOnInit(): void {
    this.getMedicine();
  }

  private getMedicine() {
    this.service.getMedicineList().subscribe(data => {
      console.log(data);
      this.medicineList = data;
      this.data = data;
      this.totalRecords = this.medicineList.length;
    });
  }

  Search() {
    if (this.medicineName != "") {
      this.medicineList = this.medicineList.filter(res => {
        return res.name.toLocaleLowerCase().match(this.medicineName.toLocaleLowerCase());
      })
    }
    else if (this.medicineName == "") {
      this.ngOnInit();
    }
  }

}
