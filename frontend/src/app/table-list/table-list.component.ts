import { Component, OnInit } from '@angular/core';
import { VentaServiceService } from '../services/venta-service.service';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  personas: any = [];

  constructor(private service: VentaServiceService) { }

  ngOnInit() {
    this.getPersons();
  }

  getPersons() {
    this.service.getPersonas().subscribe(
      res => {
        console.log(res);
        this.personas = res;
      },
      err => console.error(err)
    );
  }

  deletePerson(id: number) {
    this.service.deletePersona(id).subscribe(
      res => {
        console.log(res);
        this.getPersons();
      },
      err => console.error(err)
    );
  }

}
