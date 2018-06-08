import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ItemsListComponent } from './components/items-list/items-list.component';

const appRoutes : Routes = [
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'items',
        component: ItemsListComponent
    },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);