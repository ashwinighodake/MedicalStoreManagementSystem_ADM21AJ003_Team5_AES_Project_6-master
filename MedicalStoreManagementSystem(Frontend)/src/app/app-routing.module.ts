import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateMedicineComponent } from './create-medicine/create-medicine.component';
import { MedicineListComponent } from './medicine-list/medicine-list.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { GuardService } from './service/guard.service';
import { MedicineSalestoCustomerComponent } from './medicine-salesto-customer/medicine-salesto-customer.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerViewMedicineComponent } from './customer-view-medicine/customer-view-medicine.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { ViewCustomerDetailsComponent } from './view-customer-details/view-customer-details.component';
import { HomeComponent } from './home/home.component';
import { OrderToBePlacedComponent } from './order-to-be-placed/order-to-be-placed.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { CustomerRegistrationLoginComponent } from './customer-registration-login/customer-registration-login.component';
import { from } from 'rxjs';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { DailySalesTrackerComponent } from './daily-sales-tracker/daily-sales-tracker.component';
import { AddCustomerByAdminComponent } from './add-customer-by-admin/add-customer-by-admin.component';
import { CustomerGuardService } from './service/customer-guard.service';

const routes: Routes = [
  { path: 'medicine', component: MedicineListComponent, canActivate: [GuardService] },
  { path: 'createMedicine', component: CreateMedicineComponent, canActivate: [GuardService] },
  { path: 'customer', component: ViewCustomerDetailsComponent, canActivate: [GuardService] },
  { path: 'createCustomer', component: CreateCustomerComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'update-medicine/:id', component: UpdateMedicineComponent, canActivate: [GuardService] },
  { path: 'update-customer/:id', component: UpdateCustomerComponent, canActivate: [GuardService] },
  { path: 'logout', component: LogoutComponent },
  { path: 'viewMedicine', component: CustomerViewMedicineComponent, canActivate: [CustomerGuardService] },
  { path: 'home', component: HomeComponent },
  { path: 'order', component: OrderToBePlacedComponent },
  { path: 'medicineSalestoCustomer', component: MedicineSalestoCustomerComponent, canActivate: [GuardService] },
  { path: 'customerRegistrationLogin', component: CustomerRegistrationLoginComponent },
  { path: 'adminHome', component: AdminHomeComponent, canActivate: [GuardService] },
  { path: 'dailySales', component: DailySalesTrackerComponent, canActivate: [GuardService] },
  { path: 'customerHome', component: CustomerHomeComponent, canActivate: [CustomerGuardService] },
  { path: 'addCustomerByAdmin', component: AddCustomerByAdminComponent, canActivate: [GuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
