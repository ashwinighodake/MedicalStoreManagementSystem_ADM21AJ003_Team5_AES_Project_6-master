import { Component, OnInit } from '@angular/core';
import { MMServiceService } from '../mmservice.service';
import { MedicineDetails } from '../medicine-details';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-medicine',
  templateUrl: './update-medicine.component.html',
  styleUrls: ['./update-medicine.component.css']
})
export class UpdateMedicineComponent implements OnInit {

  id: number;
  medicine: MedicineDetails = new MedicineDetails();
  constructor(private service: MMServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.service.getMedicineListById(this.id).subscribe(data => {
      this.medicine = data
    }, error => console.log(error));
  }

  goToMedicineList() {
    this.router.navigate(['/medicine'])
  }

  onSubmit() {
    this.service.updateMedicine(this.id, this.medicine).subscribe(data => {
      this.goToMedicineList();
    }, error => console.log(error));
  }
}
