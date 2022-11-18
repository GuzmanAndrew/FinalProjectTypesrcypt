import { Component, OnInit } from '@angular/core';
import { FacturaServiceService } from '../services/factura-service.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  personas: any = [];

  constructor(private service: FacturaServiceService) { }

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
