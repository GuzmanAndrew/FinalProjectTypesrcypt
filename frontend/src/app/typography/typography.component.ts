import { Component, OnInit } from '@angular/core';
import { ClienteServiceService } from '../services/cliente-service.service';

@Component({
  selector: 'app-typography',
  templateUrl: './typography.component.html',
  styleUrls: ['./typography.component.css']
})
export class TypographyComponent implements OnInit {

  personas: any = [];

  constructor(private service: ClienteServiceService) { }

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
