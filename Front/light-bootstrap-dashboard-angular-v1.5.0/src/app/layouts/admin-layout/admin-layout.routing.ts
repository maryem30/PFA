import { Routes } from '@angular/router';

import { UserComponent } from '../../stagiaires/user.component';
import { TablesComponent } from '../../stagiaires/stagiaire.component';
import { UserUpdateComponent } from '../../stagiaires/user-update.component';
import { ResourceComponent } from '../../resource/resource.component';
import { ProjetComponent } from '../../projet/projet.component';



export const AdminLayoutRoutes: Routes = [
    { path: 'user',           component: UserComponent },
    { path: 'table',          component: TablesComponent },

    { path: 'move',          component: TablesComponent },

    { path: 'updateStagiaire',  component: UserUpdateComponent},

    { path: 'resource',  component: ResourceComponent },
    { path: 'projet',  component: ProjetComponent},

    
    



];
