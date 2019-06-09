import { InternshipListComponent } from './../../internship-list/internship-list.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LbdModule } from '../../lbd/lbd.module';
import { NguiMapModule} from '@ngui/map';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { UserComponent } from '../../stagiaires/user.component';
import { TablesComponent } from '../../stagiaires/stagiaire.component';
import { StagiairesListComponent } from '../../stagiaires-list/stagiaires-list.component';



@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    LbdModule,
    NguiMapModule.forRoot({apiUrl: 'https://maps.google.com/maps/api/js?key=YOUR_KEY_HERE'})
  ],
  declarations: [
    UserComponent,
    TablesComponent,
    StagiairesListComponent,
    InternshipListComponent
  ]
})

export class AdminLayoutModule {}
