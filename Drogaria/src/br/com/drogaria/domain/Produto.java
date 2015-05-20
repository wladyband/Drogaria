package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_produtos")
@NamedQueries({
	@NamedQuery(name = "Produto.listar", query = "SELECT p from Produto p"),
	@NamedQuery(name = "Produto.buscarPorCodigo", query = "SELECT p from Produto p where p.codigo = :codigo") })

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private Long codigo;
	
	@NotEmpty(message="O campo descri��o � obrigat�rio")
	@Size(min=5,max=50, message="Tamanho invalido para o campo (5 - 50)")
	@Column(name = "pro_descricao", length = 50, nullable = false)
	private String descricao;
	
	private String imagem;

	@NotNull(message="O campo � obrigat�rio")
	@DecimalMin(value="0.0", message="Informe um valor ou igual a zero para o campo pre�o")
	@DecimalMax(value="99999.99", message="Informe um valor menor que 100 mil para o campo pre�o")
	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@NotNull(message="O campo � obrigat�rio")
	@Min(value = 0, message="Informe um valor maior ou igual a zero para o campo quantidade")
	@Max(value = 9999, message="Informe um valor menor ou igual a 9999 para o campo quantidade")
	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;

	@NotNull(message="O campo fabricante � obrigat�rio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_fabrincantes_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
	private Fabricante fabricante;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao
				+ ", preco=" + preco + ", quantidade=" + quantidade
				+ ", fabricante=" + fabricante + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
