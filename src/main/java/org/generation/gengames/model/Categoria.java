package org.generation.gengames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

		@Id
		@GeneratedValue
		private Long id;
		@NotBlank (message = "O campo nome é obrigatório!")
		@Size (min = 3, max = 30, message = "O campo nome deve conter no minimo 03 caracteres" )
		public String nome;
		@NotBlank (message = "O campo tipo é obrigatório!")
		@Size (min = 5, max = 30, message = "O campo nome deve conter no minimo 05 caracteres" )
		public String tipo; 
		
		@OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		private List<Produtos> produtos;

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

		public List<Produtos> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produtos> produtos) {
			this.produtos = produtos;
		}		
}
