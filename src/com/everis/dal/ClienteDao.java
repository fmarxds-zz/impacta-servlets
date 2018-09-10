package com.everis.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.everis.entidades.Cliente;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
			clientes = query.getResultList();
		} catch (Exception e) {
			throw e;
		}
		return clientes;
	}

	public void salvar(Cliente cliente) {
		em.persist(cliente);
	}

}
