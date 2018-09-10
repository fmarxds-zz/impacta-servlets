package com.everis.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.everis.entidades.Usuario;
import static com.everis.utils.Utils.verificarMD5;

public class UsuarioDao {

	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	// M�todo para buscar lista de usu�rios
	public List<Usuario> buscarTodos() {
		
		List<Usuario> usuarios;
		
		try {
			
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
			
			usuarios = query.getResultList();
			
		} catch (Exception e) {
			throw e;
		}
		
		return usuarios;
		
	}

	// Met�do para validar logon
	public Usuario validaLogon(String nome, String senha) {

		Usuario usuario = null;

		try {

			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", Usuario.class)
					.setParameter("nome", nome).setParameter("senha", verificarMD5(senha));

			usuario = query.getSingleResult();

		} catch (Exception e) {
			e.initCause(new IllegalArgumentException("Usu�rio ou senha incorretos"));
			throw e;
		}

		return usuario;
	}

	public Usuario buscar(String nomeUsuario) {
		return em.find(Usuario.class, nomeUsuario);
	}

}
