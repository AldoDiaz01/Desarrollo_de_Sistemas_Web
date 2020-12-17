import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';

// PrimeNG
import { PanelModule } from 'primeng/panel';
import { TableModule } from 'primeng/table';
import { FormsModule } from '@angular/forms';
import { MenubarModule } from 'primeng/menubar';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { SidebarModule } from 'primeng/sidebar';
import { TabMenuModule } from 'primeng/tabmenu';
import {InputNumberModule} from 'primeng/inputnumber';
import {DropdownModule} from 'primeng/dropdown';
import {RatingModule} from 'primeng/rating';
import {InputSwitchModule} from 'primeng/inputswitch';
import {MenuItem} from 'primeng/api';
import {SlideMenuModule} from 'primeng/slidemenu';



// Components
import { PresidentsComponent } from './components/presidents/presidents.component';
import { HomeComponent } from './components/home/home.component';
import { PoliticalPartiesComponent } from './components/political.parties/political.parties.component';

import { SignupComponent } from './components/signup/signup.component';
import { PresidenteDataService } from './services/president.data.service';
import { UserDataService } from './services/user.data.service';
import { PoliticalDataService } from './services/political.data.service';
import { AuthGuardService } from './auth/auth-guard.service';
import { AuthService } from './auth/auth.service';


@NgModule({
  declarations: [
    AppComponent,
    PresidentsComponent,
    HomeComponent,
    PoliticalPartiesComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    TableModule,
    HttpClientModule,
    PanelModule,
    MenubarModule,
    DialogModule,
    InputTextModule,
    ButtonModule,
    ToastModule,
    ConfirmDialogModule,
    SidebarModule,
    TabMenuModule,
    InputNumberModule,
    RatingModule,
    InputSwitchModule,
    DropdownModule,
    SlideMenuModule
  ],
  providers: [PresidenteDataService, MessageService, ConfirmationService, UserDataService, PoliticalDataService, AuthGuardService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
