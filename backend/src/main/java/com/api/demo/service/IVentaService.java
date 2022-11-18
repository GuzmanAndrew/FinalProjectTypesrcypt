package com.api.demo.service;

import com.api.demo.db.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> listarVentas();

    public Venta guardarVenta(Venta venta);

    public Venta ventaId(Long id);

    public Venta actualizarVenta(Venta venta);

    public void eliminarVenta(Long id);
}
