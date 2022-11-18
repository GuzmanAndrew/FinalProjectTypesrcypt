package com.api.demo.dao;

import com.api.demo.db.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaDao extends JpaRepository<Venta, Long> {
}
