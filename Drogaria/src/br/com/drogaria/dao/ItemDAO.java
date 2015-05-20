package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Item;
import br.com.drogaria.util.HibernateUtil;

public class ItemDAO {

	public void salvar(Item item) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(item);
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
	public List<Item> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Item> itens = null;
		try {
			Query consulta = sessao.getNamedQuery("Item.listar");
			itens = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return itens;

	}

	public Item buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Item item = null;
		try {
			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			item = (Item) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return item;

	}

	public void excluir(Item item) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(item);
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

	public void editar(Item item) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.update(item);
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
