package com.everis.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.everis.enumeracoes.Niveis;

@Entity
@Table(name = "usuarios")
public class Usuario {

	/** Definição dos atributos **/

	@Id
	@Column(name = "NOME")
	private String nome;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "NIVEL")
	@Enumerated(value = EnumType.STRING)
	private Niveis nivel;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Cliente> clientes = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Prestador> prestadores = new HashSet<>();

	/** Definição dos atributos **/

	@Override
	public String toString() {
		return this.getNome() + " : " + this.getNivel().toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Niveis getNivel() {
		return nivel;
	}

	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Prestador> getPrestadores() {
		return prestadores;
	}

	public void setPrestadores(Set<Prestador> prestadores) {
		this.prestadores = prestadores;
	}

}
