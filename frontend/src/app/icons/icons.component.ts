import { Component, OnInit } from '@angular/core';
import { Factura } from '../model/Factura';
import { ActivatedRoute, Router } from '@angular/router';
import { FacturaServiceService } from '../services/factura-service.service';

@Component({
  selector: 'app-icons',
  templateUrl: './icons.component.html',
  styleUrls: ['./icons.component.css']
})
export class IconsComponent implements OnInit {

  persona: Factura = {
    id: 0,
    numberInvoice: '',
    nameClient: '',
    dateCreate: '',
    seller: '',
    total: '',
  };
  edit: boolean = false;
  constructor(private service: FacturaServiceService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    const params = this.activatedRoute.snapshot.params;
    if (params.id) {
      this.service.getPersonaId(params.id).subscribe(
        res => {
          console.log(res);
          this.persona = res;
          this.edit = true;
        },
        err => console.error(err)
      );
    }
  }

  savePerson() {
    delete this.persona.id;
    this.service.createPersona(this.persona).subscribe(
      res => {
        console.log(res);
        this.router.navigate(['/person']);
      },
      err => console.error(err)
    );
  }

  updatePerson() {
    this.service.updatePersona(this.persona.id, this.persona).subscribe(
      res => {
        console.log(res);
        this.router.navigate(['/person']);
      },
      err => console.error(err)
    );
  }

}
