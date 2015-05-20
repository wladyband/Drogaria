package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

public class ProdutoDAO {

	public void salvar(Produto produto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(produto);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();

		}

	}
	
	
	
	public Produto buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Produto produto = null;
		try {
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			produto = (Produto) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return produto;

	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Produto> produtos = null;
		try {
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produtos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return produtos;

	}
	


	public void excluir(Produto produto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(produto);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();

		}

	}
	
	public void editar(Produto produto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(produto);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			session.close();

		}

	}


}
