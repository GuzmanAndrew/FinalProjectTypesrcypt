package com.api.demo.db;

import javax.persistence.*;

@Entity
@Table(name="factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;

    @Column(name = "name_client")
    private String nameClient;

    @Column(name = "date_create")
    private String dateCreate;

    @Column(name = "seller")
    private String seller;

    @Column(name = "total")
    private String total;

    public Factura() {
    }

    public Factura(Long id, String numberInvoice, String nameClient, String dateCreate, String seller, String total) {
        this.id = id;
        this.numberInvoice = numberInvoice;
        this.nameClient = nameClient;
        this.dateCreate = dateCreate;
        this.seller = seller;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
