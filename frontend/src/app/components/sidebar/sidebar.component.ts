import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Bienvenida', class: '' },
    { path: '/user-profile', title: 'Consulta Facturas', class: '' },
    { path: '/table-list', title: 'Consulta Ventas',  class: '' },
    { path: '/typography', title: 'Consulta Clientes',  class: '' },
    { path: '/icons', title: 'Crear Facturas', class: '' },
    { path: '/maps', title: 'Crear Ventas',  class: '' },
    { path: '/notifications', title: 'Crear Clientes',  class: '' }
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
}
