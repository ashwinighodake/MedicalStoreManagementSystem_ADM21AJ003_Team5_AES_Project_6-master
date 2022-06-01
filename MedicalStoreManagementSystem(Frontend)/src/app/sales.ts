import { CustomerDetails } from "./customer-details";
import { MedicineDetails } from "./medicine-details";

export class Sales {
    medicineId: number;
    customerPhone: String;
    quantity: number;
    medicine: MedicineDetails[];
    customer: CustomerDetails[];
    date: Date;
    amount: number;
}
