import {Component} from '@angular/core';

@Component({
    selector: 'about',
    template: `<h1>{{welcome}}</h1>`
})
export class AboutComponent {
    welcome : string;
    constructor(){
        this.welcome = "Welcome to about page"
    };
};