package com.api.demo.controller;

import com.api.demo.db.Cliente;
import com.api.demo.db.Factura;
import com.api.demo.service.impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin
public class FacturaController {

    @Autowired
    FacturaServiceImpl facturaService;

    @GetMapping("/listar")
    public List<Factura> listarClientes(){
        return facturaService.listarFacturas();
    }

    @PostMapping("/crear")
    public Factura guardarCliente(@RequestBody Factura factura) {
        return facturaService.guardarFactura(factura);
    }

    @GetMapping("/buscar/{id}")
    public Factura clienteId(@PathVariable(name = "id") Long id) {
        Factura facturaId = new Factura();
        facturaId = facturaService.facturaId(id);
        return facturaId;
    }

    @PutMapping("/actualizar/{id}")
    public Factura actualizarCliente(@PathVariable(name = "id") Long id, @RequestBody Factura factura) {
        Factura facturaSelect = new Factura();
        Factura facturaUpdate = new Factura();

        facturaSelect = facturaService.facturaId(id);
        facturaSelect.setNumberInvoice(factura.getNumberInvoice());
        facturaSelect.setNameClient(factura.getNameClient());
        facturaSelect.setDateCreate(factura.getDateCreate());
        facturaSelect.setSeller(factura.getSeller());
        facturaSelect.setTotal(factura.getTotal());

        facturaUpdate = facturaService.actualizarFactura(facturaSelect);

        System.out.println("El cliente actualizado es: " + facturaUpdate);

        return facturaUpdate;
    }

    @DeleteMapping("/borrar/{id}")
    public void clienteDelete(@PathVariable(name = "id") Long id) {
        facturaService.eliminarFactura(id);
    }
}