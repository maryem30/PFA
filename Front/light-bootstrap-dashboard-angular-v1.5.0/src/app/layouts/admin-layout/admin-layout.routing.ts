import { InternshipinvalidListComponent } from './../../internshipinvalid-list/internshipinvalid-list.component';
import { InternshipListComponent } from './../../internship-list/internship-list.component';
import { Routes } from '@angular/router';

import { UserComponent } from '../../stagiaires/user.component';
import { TablesComponent } from '../../stagiaires/stagiaire.component';
import { UserUpdateComponent } from '../../stagiaires/user-update.component';
import { StagiairesListComponent } from '../../stagiaires-list/stagiaires-list.component';
import { AdministratorListComponent } from '../../administrator-list/administrator-list.component';
import { TeamComponent } from '../../Team/team.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'user',           component: UserComponent },
    { path: 'table',          component: TablesComponent },
    { path: 'stagiaire-list',        component: StagiairesListComponent },
    { path: 'move',          component: TablesComponent },
    { path: 'internship',  component: InternshipListComponent},
    { path: 'internshipinvalid',  component: InternshipinvalidListComponent},
    { path: 'updateStagiaire',  component: UserUpdateComponent},
    { path: 'administration',  component: AdministratorListComponent},
    { path: 'team',  component: TeamComponent}

    



];
