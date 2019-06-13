import { InternshipinvalidService } from './internshipinvalid-list/internshipinvalid.service';
import { StagiaireService } from './stagiaires/stagiaire.service';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app.routing';
import { NavbarModule } from './shared/navbar/navbar.module';
import { FooterModule } from './shared/footer/footer.module';
import { SidebarModule } from './sidebar/sidebar.module';

import { AppComponent } from './app.component';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';


import { HttpClientModule } from '@angular/common/http';
import { InternshipService } from './internship-list/internship.service';
import { AdministratorService } from './administrator-list/administrator-list.service';
import { TeamService } from './Team/team.service';


@NgModule({
  imports: [
    BrowserAnimationsModule,
    RouterModule,
    HttpModule,
    NavbarModule,
    FooterModule,
    SidebarModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    
  ],
  providers: [StagiaireService, InternshipService, InternshipinvalidService,AdministratorService,TeamService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
