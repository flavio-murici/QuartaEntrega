package com.recodeturismo.QuartaEntrega.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	
	@Column (columnDefinition = "TEXT")
	private String telefone;
	
	@Column
	private String cpf;
	
	@Column
	private String email;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "cliente")
	private Set<Pacote> pacote = new HashSet<>();
	
	
	public Cliente(String cpf, String email) {
		super();
		this.cpf = cpf;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente(Long id, String nome, String telefone, String email, String cpf) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}

	public List<Cliente> getPacotes() {
		return null;
	}


	
	
	
	
}
