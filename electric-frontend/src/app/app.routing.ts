import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ItemsListComponent } from './components/items-list/items-list.component';
import { ItemDetailsComponent } from './components/item-details/item-details.component';

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
    {
        path: 'itemDetails/:id',
        component: ItemDetailsComponent
    },
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);