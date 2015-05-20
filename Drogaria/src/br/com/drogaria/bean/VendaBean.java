package br.com.drogaria.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class VendaBean {

	private Long codigo;
	private Produto produtoCadastro;
	private List<Item> listaItens;
	
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	
	public String adicionar(Produto produto){

		int posicaoEntrada = -1;
		
		for (int pos = 0; pos < listaItens.size() && posicaoEntrada < 0; pos++) {
			Item itemTemp = listaItens.get(pos);
		
			if(itemTemp.getProduto().equals(produto)){
				posicaoEntrada = pos;
			}
		}
		
		
        Item item = new Item();
        item.setProduto(produto);
        
        if(posicaoEntrada <0){
            item.setQuantidade(1);
            item.setValor(produto.getPreco());
            listaItens.add(item);
        	
        }else{
        	Item itemTemp = listaItens.get(posicaoEntrada);
        	item.setQuantidade(itemTemp.getQuantidade() + 1);
        	item.setValor(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
        	listaItens.set(posicaoEntrada, item);
        }

//        System.out.println(produto);

        //return "carrinhoCompras.xhtml?faces-redirect=true"
        return "carrinhoCompras?faces-redirect=true ";


    }
	
	public void remover(Item item){

		int posicaoEntrada = -1;
		
		for (int pos = 0; pos < listaItens.size() && posicaoEntrada < 0; pos++) {
			Item itemTemp = listaItens.get(pos);
		
			if(itemTemp.getProduto().equals(item.getProduto())){
				posicaoEntrada = pos;
			}
		}
		if(posicaoEntrada > -1){
			listaItens.remove(posicaoEntrada);
		}

	}
	
	public void carregarProdutos() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao listar produtos"
					+ ex.getMessage());

		}
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


	public List<Item> getListaItens() {
		if(listaItens == null){
			listaItens = new ArrayList<>();
		}
		return listaItens;
	}


	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}




}
