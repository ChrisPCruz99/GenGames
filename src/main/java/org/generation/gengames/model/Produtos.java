package org.generation.gengames.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank (message = "O campo nome é obrigatório!")
	@Size (min = 3, max = 30, message = "O campo nome deve conter no minimo 03 caracteres" )
	public String nome;
	@NotNull
	public BigDecimal valor;
	@NotBlank (message = "O campo marca é obrigatório!")
	@Size (min = 3, max = 30, message = "O campo marca deve conter no minimo 03 caracteres" )
	public String marca;
	@NotBlank (message = "O campo descrição é obrigatório!")
	@Size (min = 10, max = 500, message = "O campo descrição deve conter no minimo 10 caracteres" )
	public String descricao;
	@NotBlank (message = "O campo garantia é obrigatório!")
	@Size (min = 3, max = 10, message = "O campo garantia deve conter no minimo 10 caracteres" )
	public String garantia;
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public LocalDate dataLancamento;
	
	@ManyToOne
	@JsonIgnoreProperties ("produtos")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties ("produtos")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}