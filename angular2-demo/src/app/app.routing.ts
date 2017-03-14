import { AboutComponent } from './about/about.component';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  
  {
    path: 'home',
    component: HomeComponent,
    children: [
      { path: 'about', component: AboutComponent }

    ]
  },
  

  { path: 'login', component: LoginComponent },

  // otherwise redirect to login
  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);