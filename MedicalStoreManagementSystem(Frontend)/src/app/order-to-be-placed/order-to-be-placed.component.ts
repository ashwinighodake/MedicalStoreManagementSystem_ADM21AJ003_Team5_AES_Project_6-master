import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MedicineDetails } from '../medicine-details';
import { MMServiceService } from '../mmservice.service';

@Component({
  selector: 'app-order-to-be-placed',
  templateUrl: './order-to-be-placed.component.html',
  styleUrls: ['./order-to-be-placed.component.css']
})
export class OrderToBePlacedComponent implements OnInit {

  medicineList: MedicineDetails[];
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
    this.service.getMedicineToOrder().subscribe(data => {
      console.log(data);
      this.medicineList = data;
      this.data = data;
      this.totalRecords = this.medicineList.length;
    });
  }

}
