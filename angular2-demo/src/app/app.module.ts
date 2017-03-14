import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { routing } from './app.routing';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

@NgModule({
   declarations: [
    AppComponent, AboutComponent , HomeComponent, LoginComponent
  ],
  imports: [
    BrowserModule, routing
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
