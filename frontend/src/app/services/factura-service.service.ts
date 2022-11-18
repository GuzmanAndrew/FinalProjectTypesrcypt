import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Factura } from '../model/Factura';

@Injectable({
  providedIn: 'root'
})
export class FacturaServiceService {

  Url = 'http://localhost:8080/api/facturas';

  constructor(private http: HttpClient) { }

  getPersonas() {
    return this.http.get(`${this.Url}/listar`);
  }

  getPersonaId(id: string) {
    return this.http.get(`${this.Url}/buscar/${id}`);
  }

  deletePersona(id: number) {
    return this.http.delete(`${this.Url}/borrar/${id}`);
  }

  createPersona(persona: Factura) {
    return this.http.post(`${this.Url}/crear`, persona);
  }

  updatePersona(id: string | number, updatePersona: Factura) {
    return this.http.put(`${this.Url}/actualizar/${id}`, updatePersona);
  }
}
