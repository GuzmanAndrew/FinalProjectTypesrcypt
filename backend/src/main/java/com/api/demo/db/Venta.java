package com.api.demo.db;

import javax.persistence.*;

@Entity
@Table(name="venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;

    @Column(name = "code_product")
    private String codeProduct;

    @Column(name = "amount")
    private String amount;

    @Column(name = "important")
    private String important;

    public Venta() {
    }

    public Venta(Long id, String numberInvoice, String codeProduct, String amount, String important) {
        this.id = id;
        this.numberInvoice = numberInvoice;
        this.codeProduct = codeProduct;
        this.amount = amount;
        this.important = important;
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

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

}
