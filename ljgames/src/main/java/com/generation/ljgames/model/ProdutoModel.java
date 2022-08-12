package com.generation.ljgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull( message="Informe o nome do jogo")
	@Size(min= 10, max=500, message= "O nome deve conter no mínimo 10 e no máximo 500 caracteres")
	private String nome;
	
	@NotNull(message= "Informe o tipo de game que deseja")
	@Size(min= 10, max=500, message= "O tipo deve conter no mínimo 10 e no máximo 500 caracteres")
	private String tipo;
	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private CategoriaModel categoria;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private UsuarioModel usuario;
	
	

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	

}
