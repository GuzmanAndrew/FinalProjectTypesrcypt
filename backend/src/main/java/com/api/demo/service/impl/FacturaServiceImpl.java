package com.api.demo.service.impl;

import com.api.demo.dao.IFacturaDao;
import com.api.demo.db.Factura;
import com.api.demo.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    IFacturaDao facturaDao;

    @Override
    public List<Factura> listarFacturas() {
        return facturaDao.findAll();
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    public Factura facturaId(Long id) {
        return facturaDao.findById(id).get();
    }

    @Override
    public Factura actualizarFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaDao.deleteById(id);
    }
}
