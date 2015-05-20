package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produtoCadastro;
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	private List<Fabricante> listaFabricantes;

	private String acao;
	private Long codigo;

	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produtoCadastro);
			
			produtoCadastro = new Produto();
			
			FacesUtil.adicionarMsgInfo("Produto salvo com sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao salvar produto "
					+ ex.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar produtos"
					+ ex.getMessage());

		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoCadastro = produtoDAO.buscarPorCodigo(codigo);
			} else {
				produtoCadastro = new Produto();
			}
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao obter dados do produto: "
					+ ex.getMessage());

		}
	}

	public void excluir() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produtoCadastro);
			FacesUtil.adicionarMsgInfo("Produto foi removido com sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao remover o produto: "
					+ ex.getMessage());
		}
	}

	public void editar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.editar(produtoCadastro);
			FacesUtil.adicionarMsgInfo("Produto foi editado com sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao editar o produto: "
					+ ex.getMessage());
		}
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Produto getProdutoCadastro() {
		return produtoCadastro;
	}

	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}

	public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}
	
	

}
