import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/user', title: 'User Profile',  icon: 'pe-7s-user', class: '' },
    { path: '/table', title: 'Table List',  icon: 'pe-7s-note2', class: '' },
    { path: '/stagiaire-list', title: 'stagiaire',  icon: 'pe-7s-rocket', class: '' },
    { path: '/internship', title: 'Stages valides',  icon: 'pe-7s-rocket', class: '' },

];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem)
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
