package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.save(fabricante);
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
	public List<Fabricante> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return fabricantes;

	}

	public Fabricante buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return fabricante;

	}

	public void excluir(Fabricante fabricante) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			session.delete(fabricante);
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

	public void editar(Fabricante fabricante) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = session.beginTransaction();
			// Fabricante fabricanteEditar =
			// buscarPorCodigo(fabricante.getCodigo());
			// fabricanteEditar.setDescricao(fabricante.getDescricao());

			session.update(fabricante);

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
