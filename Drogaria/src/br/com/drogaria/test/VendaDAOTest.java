package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	public void salvar() {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);
		
		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(12.14D));
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
	}
	
	@Test
	@Ignore
	public void listar(){
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> venda = vendaDAO.listar();
		
		System.out.println(venda);
	}

	@Test
	@Ignore
	public void buscarPorCodigo(){
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		
		System.out.println(venda);
	}

	@Test
	@Ignore
	public void excluir(){
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		vendaDAO.excluir(venda);
	}
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(2L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		
		venda.setHorario(Calendar.getInstance().getTime());
		venda.setValor(new BigDecimal(12.34D));
		venda.setFuncionario(funcionario);
		vendaDAO.editar(venda);
		
		vendaDAO.excluir(venda);
	}
	

}
