package com.api.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.db.Cliente;
import com.api.demo.service.impl.ClienteServiveImp;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin
public class ClientController {
	
	@Autowired
	ClienteServiveImp clienteServiveImp;
	
	@GetMapping("/listar")
	public List<Cliente> listarClientes(){
		return clienteServiveImp.listarClientes();
	}
	
	@PostMapping("/crear")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return clienteServiveImp.guardarCliente(cliente);
	}
	
	@GetMapping("/buscar/{id}")
	public Cliente clienteId(@PathVariable(name = "id") Long id) {
		Cliente clienteId = new Cliente();
		clienteId = clienteServiveImp.clienteId(id);
		return clienteId;
	}
	
	@PutMapping("/actualizar/{id}")
	public Cliente actualizarCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteSelect = new Cliente();
		Cliente clienteUpdate = new Cliente();
		
		clienteSelect = clienteServiveImp.clienteId(id);
		clienteSelect.setNumberClient(cliente.getNumberClient());
		clienteSelect.setNameClient(cliente.getNameClient());
		clienteSelect.setLastNameClient(cliente.getLastNameClient());
		clienteSelect.setNumberIdentification(cliente.getNumberIdentification());
		
		clienteUpdate = clienteServiveImp.actualizarCliente(clienteSelect);
		
		System.out.println("El cliente actualizado es: " + clienteUpdate);
		
		return clienteUpdate;
	}
	
	@DeleteMapping("/borrar/{id}")
	public void clienteDelete(@PathVariable(name = "id") Long id) {
		clienteServiveImp.eliminarCliente(id);
	}
}
