package com.api.demo.controller;

import com.api.demo.db.Cliente;
import com.api.demo.db.Factura;
import com.api.demo.db.Venta;
import com.api.demo.service.impl.VentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin
public class VentaController {

    @Autowired
    VentaServiceImpl ventaService;

    @GetMapping("/listar")
    public List<Venta> listarClientes(){
        return ventaService.listarVentas();
    }

    @PostMapping("/crear")
    public Venta guardarCliente(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @GetMapping("/buscar/{id}")
    public Venta clienteId(@PathVariable(name = "id") Long id) {
        Venta ventaId = new Venta();
        ventaId = ventaService.ventaId(id);
        return ventaId;
    }

    @PutMapping("/actualizar/{id}")
    public Venta actualizarCliente(@PathVariable(name = "id") Long id, @RequestBody Venta venta) {
        Venta ventaSelect = new Venta();
        Venta ventaUpdate = new Venta();

        ventaSelect = ventaService.ventaId(id);
        ventaSelect.setNumberInvoice(venta.getNumberInvoice());
        ventaSelect.setCodeProduct(venta.getCodeProduct());
        ventaSelect.setAmount(venta.getAmount());
        ventaSelect.setImportant(venta.getImportant());

        ventaUpdate = ventaService.actualizarVenta(ventaSelect);

        System.out.println("El cliente actualizado es: " + ventaUpdate);

        return ventaUpdate;
    }

    @DeleteMapping("/borrar/{id}")
    public void clienteDelete(@PathVariable(name = "id") Long id) {
        ventaService.eliminarVenta(id);
    }
}
