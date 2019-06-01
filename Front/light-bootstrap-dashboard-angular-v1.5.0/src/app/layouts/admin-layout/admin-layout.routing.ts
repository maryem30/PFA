import { Routes } from '@angular/router';

import { UserComponent } from '../../user/user.component';
import { TablesComponent } from '../../tables/tables.component';
import { StagiairesListComponent } from '../../stagiaires-list/stagiaires-list.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'user',           component: UserComponent },
    { path: 'table',          component: TablesComponent },
    { path: 'stagiaire-list',        component: StagiairesListComponent },
];
