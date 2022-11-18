package com.api.demo.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "number_client")
	private String numberClient;
	
	@Column(name = "name_client")
	private String nameClient;
	
	@Column(name = "last_name_client")
	private String lastNameClient;
	
	@Column(name = "number_identification")
	private String numberIdentification;

	public Cliente() {
	
	}

	public Cliente(Long id, String numberClient, String nameClient, String lastNameClient, String numberIdentification) {
		this.id = id;
		this.numberClient = numberClient;
		this.nameClient = nameClient;
		this.lastNameClient = lastNameClient;
		this.numberIdentification = numberIdentification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberClient() {
		return numberClient;
	}

	public void setNumberClient(String numberClient) {
		this.numberClient = numberClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getLastNameClient() {
		return lastNameClient;
	}

	public void setLastNameClient(String lastNameClient) {
		this.lastNameClient = lastNameClient;
	}

	public String getNumberIdentification() {
		return numberIdentification;
	}

	public void setNumberIdentification(String numberIdentification) {
		this.numberIdentification = numberIdentification;
	}
}
