import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MedicineDetails } from '../medicine-details';
import { MMServiceService } from '../mmservice.service';

@Component({
  selector: 'app-create-medicine',
  templateUrl: './create-medicine.component.html',
  styleUrls: ['./create-medicine.component.css']
})
export class CreateMedicineComponent implements OnInit {

  medicine: MedicineDetails = new MedicineDetails();
  constructor(private createService: MMServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveMedicine() {
    this.createService.createMedicine(this.medicine).subscribe(data => {
      console.log(data);
      this.goToMedicineList();
    },
      error => console.error(error));
  }

  goToMedicineList() {
    this.router.navigate(['/medicine'])
  }
  onSubmit() {
    console.log(this.medicine);
    this.saveMedicine();
  }
}
