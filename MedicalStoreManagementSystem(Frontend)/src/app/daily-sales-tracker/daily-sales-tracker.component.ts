import { Component, OnInit } from '@angular/core';
import { Sales } from '../sales';
import { SalesServiceService } from '../sales-service.service';
import { CustomerDetails } from '../customer-details';

@Component({
  selector: 'app-daily-sales-tracker',
  templateUrl: './daily-sales-tracker.component.html',
  styleUrls: ['./daily-sales-tracker.component.css']
})
export class DailySalesTrackerComponent implements OnInit {

  date: Date;
  sales: Sales = new Sales();
  salesList: Sales[];
  msg:string = '';
  constructor(private service: SalesServiceService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.getDailySales(this.sales.date).subscribe(data => {
      this.salesList = data;
      console.log(this.salesList);
      if(data.length === 0){
        this.msg="**No sales found on this Date**";
      }
      else{
        this.msg='';
      }
    })
  }
}
