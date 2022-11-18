import { Component, OnInit } from '@angular/core';
import { Cliente } from '../model/Cliente';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteServiceService } from '../services/cliente-service.service';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  persona: Cliente = {
    id: 0,
    numberClient: '',
    nameClient: '',
    lastNameClient: '',
    numberIdentification: ''
  };
  edit: boolean = false;
  constructor(private service: ClienteServiceService, private router: Router, private activatedRoute: ActivatedRoute) { }

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
        this.router.navigate(['/typography']);
      },
      err => console.error(err)
    );
  }

  updatePerson() {
    this.service.updatePersona(this.persona.id, this.persona).subscribe(
      res => {
        console.log(res);
        this.router.navigate(['/typography']);
      },
      err => console.error(err)
    );
  }

}
