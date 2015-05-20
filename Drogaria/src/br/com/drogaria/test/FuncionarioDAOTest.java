package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	public void salvar(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("111.111.111-11");
		funcionario.setFuncao("administrador");
		funcionario.setNome("Jo�o Pessoa");
		funcionario.setSenha("123");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(funcionario);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		System.out.println(funcionarios);
		
	}
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		
		System.out.println(funcionario);
	}
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		
		funcionario.setCpf("121.111.111-12");
		funcionario.setFuncao("medico");
		funcionario.setNome("Paulo");
		funcionario.setSenha("1234");
		
		dao.editar(funcionario);
		System.out.println(funcionario);

	}
	
	
	
}
