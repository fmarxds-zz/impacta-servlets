package com.everis.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.everis.entidades.Prestador;

public class PrestadorDao {
	
	private EntityManager em;

	public PrestadorDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Prestador> buscarTodos() {
		List<Prestador> prestadores = new ArrayList<>();
		try {
			TypedQuery<Prestador> query = em.createQuery("SELECT p FROM Prestador p", Prestador.class);
			prestadores = query.getResultList();
		} catch (Exception e) {
			System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
			throw e;
		}
		return prestadores;
	}

}
