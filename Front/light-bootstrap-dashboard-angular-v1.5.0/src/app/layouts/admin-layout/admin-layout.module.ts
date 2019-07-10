import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LbdModule } from '../../lbd/lbd.module';
import { NguiMapModule} from '@ngui/map';

import { AdminLayoutRoutes } from './admin-layout.routing';
import { UserUpdateComponent } from '../../stagiaires/user-update.component';

import { UserComponent } from '../../stagiaires/user.component';
import { TablesComponent } from '../../stagiaires/stagiaire.component';
import { ResourceComponent } from '../../resource/resource.component';
import { ProjetComponent } from '../../projet/projet.component';

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
   ResourceComponent,
   ProjetComponent,
    UserUpdateComponent ,
   

  ]
})

export class AdminLayoutModule {}
