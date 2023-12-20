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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacote")
public class Pacote {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="pacote_nome", length = 50, nullable = false)
	private String nome;
	
	@Column (columnDefinition = "TEXT")
	private String descricao;
	
	@Column
	private Double valor;
	
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "cliente_pacote",
	joinColumns = @JoinColumn (name = "cliente_id"),
	inverseJoinColumns = @JoinColumn (name = "pacote_id"))
	private Set<Cliente> cliente = new HashSet<>();
		
	
	public Pacote() {
		
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	

	public Set<Cliente> getCliente(){
		return cliente;
		    }

	public void setCliente(Set<Cliente> cliente) {
		        this.cliente = cliente;
		    }
	
	public List<Pacote> getClientes() {

        return null;
    }

    public List<Pacote> getPacotes() {

        return null;
    }
	
	

}
