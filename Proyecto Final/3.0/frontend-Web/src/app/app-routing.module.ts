import { NgModule } from '@angular/core';
import {Routes, RouterModule, CanActivate} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PoliticalPartiesComponent } from './components/political.parties/political.parties.component';
import { PresidentsComponent } from './components/presidents/presidents.component';
import { SignupComponent } from './components/signup/signup.component';
import {AuthGuardService as AuthGuard } from './auth/auth-guard.service';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'presidents',
    component: PresidentsComponent,
    canActivate: [AuthGuard] 
  },
  {
    path: 'political',
    component: PoliticalPartiesComponent,
    canActivate: [AuthGuard] 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
