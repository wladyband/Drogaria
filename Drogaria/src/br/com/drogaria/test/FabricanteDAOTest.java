package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	public void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("descricaoA");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("descricaoB");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);

	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();

		for (Fabricante fabricante : fabricantes) {

			System.out.println(fabricante);
		}
	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(2L);

			dao.excluir(f1);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(3L);
		fabricante.setDescricao("descricaoYX");

		dao.editar(fabricante);
		
	}
	
}
