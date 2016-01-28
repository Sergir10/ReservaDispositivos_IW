package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.UsuarioDAO;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase encargada de implementar los metodos que se definieron en la interface
 * UsuarioDAO
 * 
 * @author sergir10
 *
 */
public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {

	/**
	 * Metodo crearUsuario(Usuario usuario) es el encargado de crear un nuevo
	 * usuario y almacenarlo en la BD.
	 * 
	 * @param usuario
	 *            a almacenar en la base de datos.
	 * @throws MyException
	 */
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

	/**
	 * Metodo modificarUsuario(Usuario usuario) es el encargado de permitir
	 * modificar un usuario almacenado en la base de datos
	 * 
	 * @param usuario
	 *            a modificar.
	 * @throws MyException
	 */
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

	/**
	 * Metodo eliminar(Usuario usuario) es el encargado de permitir eliminar a
	 * un usuario de la BD.
	 * 
	 * @param usuario
	 *            a eliminar.
	 * @throws MyException
	 */
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

	/**
	 * Metodo obtenerUsuario(String username) es el encargado de obtener un
	 * usuario especifico en la BD por medio del parametro ingresado
	 * 
	 * @param username para realizar la busqueda.
	 * @return Usuario buscado.
	 * @throws MyException
	 */
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

	@Override
	public List<Usuario> listarUsuarios() throws MyException {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
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

		return usuarios;
	}

}
