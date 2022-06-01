import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MedicineDetails } from '../medicine-details';
import { MMServiceService } from '../mmservice.service';

@Component({
  selector: 'app-medicine-list',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css']
})
export class MedicineListComponent implements OnInit {

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

  updateMedicine(id: number) {
    this.router.navigate(['update-medicine', id]);
  }

  deleteMedicine(id: number) {
    this.service.deleteMedicine(id).subscribe(data => {
      console.log(data);
      this.getMedicine();
    })
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
