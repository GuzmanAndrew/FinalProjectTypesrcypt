package com.api.demo.service.impl;

import com.api.demo.dao.IVentaDao;
import com.api.demo.db.Venta;
import com.api.demo.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    IVentaDao ventaDao;

    @Override
    public List<Venta> listarVentas() {
        return ventaDao.findAll();
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaDao.save(venta);
    }

    @Override
    public Venta ventaId(Long id) {
        return ventaDao.findById(id).get();
    }

    @Override
    public Venta actualizarVenta(Venta venta) {
        return ventaDao.save(venta);
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaDao.deleteById(id);
    }
}
