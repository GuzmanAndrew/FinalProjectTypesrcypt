import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Venta } from '../model/Venta';

@Injectable({
  providedIn: 'root'
})
export class VentaServiceService {

  Url = 'http://localhost:8080/api/ventas';

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

  createPersona(persona: Venta) {
    return this.http.post(`${this.Url}/crear`, persona);
  }

  updatePersona(id: string | number, updatePersona: Venta) {
    return this.http.put(`${this.Url}/actualizar/${id}`, updatePersona);
  }
}
