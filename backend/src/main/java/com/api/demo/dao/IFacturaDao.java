package com.api.demo.dao;

import com.api.demo.db.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaDao extends JpaRepository<Factura, Long> {
}
