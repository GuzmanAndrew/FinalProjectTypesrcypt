package com.api.demo.service;

import com.api.demo.db.Factura;

import java.util.List;

public interface IFacturaService {
    public List<Factura> listarFacturas();

    public Factura guardarFactura(Factura factura);

    public Factura facturaId(Long id);

    public Factura actualizarFactura(Factura factura);

    public void eliminarFactura(Long id);
}
