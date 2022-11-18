import { Component, OnInit } from '@angular/core';
import { Venta } from '../model/Venta';
import { ActivatedRoute, Router } from '@angular/router';
import { VentaServiceService } from '../services/venta-service.service';

declare const google: any;

interface Marker {
lat: number;
lng: number;
label?: string;
draggable?: boolean;
}
@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {

    persona: Venta = {
        id: 0,
        numberInvoice: '',
        codeProduct: '',
        amount: '',
        important: ''
      };
      edit: boolean = false;
      constructor(private service: VentaServiceService, private router: Router, private activatedRoute: ActivatedRoute) { }
    
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
            this.router.navigate(['/table-list']);
          },
          err => console.error(err)
        );
      }
    
      updatePerson() {
        this.service.updatePersona(this.persona.id, this.persona).subscribe(
          res => {
            console.log(res);
            this.router.navigate(['/table-list']);
          },
          err => console.error(err)
        );
      }

}
