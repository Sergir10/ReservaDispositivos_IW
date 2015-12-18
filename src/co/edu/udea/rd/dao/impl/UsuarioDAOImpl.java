package co.edu.udea.rd.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.UsuarioDAO;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	@Override
	public void crearUsuario(Usuario usuario) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(usuario);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
	}

	@Override
	public void modificarUsuario(Usuario usuario) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(usuario);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}

	}

	@Override
	public void eliminar(Usuario usuario) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();
		} catch (Exception e) {
			throw new MyException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}

	}

	@Override
	public Usuario obtenerUsuario(String username) throws MyException {
		Usuario usuario = new Usuario();
		Session session = null;
		try {
			session = getSession();
			session.createCriteria(Usuario.class).add(Restrictions.eq("username", username));
			usuario = (Usuario) session.get(Usuario.class, username);
		} catch (Exception e) {
			throw new MyException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
		return usuario;
	}

}
