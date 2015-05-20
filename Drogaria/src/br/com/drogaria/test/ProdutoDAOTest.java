package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void inserir() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(3L);

		Produto produto = new Produto();
			
		produto.setDescricao("descricaoY");
		produto.setPreco(new BigDecimal(24.50D));
		produto.setQuantidade(17);
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		
		System.out.println(produto);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> produtos = produtoDAO.listar();
		
		System.out.println(produtos);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		produtoDAO.excluir(produto);
		
		System.out.println(produto);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(1L);
		
		produto.setDescricao("descmkmkmkm");
		produto.setPreco(new BigDecimal(6.30D));
		produto.setQuantidade(9);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(4L);
		produto.setFabricante(fabricante);
		
		produtoDAO.editar(produto);
		
		System.out.println(produto);
		
	}
	
	
	

	
}
