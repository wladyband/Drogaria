package br.com.drogaria.dao;	

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Venda;
import br.com.drogaria.util.HibernateUtil;

public class VendaDAO {
	
	public void salvar(Venda venda) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(venda);
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
	
	@SuppressWarnings("unchecked")
	public List<Venda> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> vendas = null;
		try {
			Query consulta = sessao.getNamedQuery("Venda.listar");
			vendas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return vendas;

	}
	
	public Venda buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Venda venda = null;
		try {
			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			venda = (Venda) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}  
		return venda;

	}

	public void excluir(Venda venda) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(venda);
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
	
	public void editar(Venda venda) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(venda);
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
