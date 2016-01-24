package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.DispositivoDAO;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase encargada de implementar los metodos definidos en la interface
 * DispositivoDAO
 * 
 * @author sergir10
 *
 */
public class DispositivoDAOImpl extends HibernateDaoSupport implements DispositivoDAO {

	/**
	 * Metodo listarDispositivos() es el encargado de retornar la lista de los
	 * dispositivos disponibles en la base de datos
	 * 
	 * @return lista con los dispositivos
	 * @throws MyException
	 */
	@Override
	public List<Dispositivo> listarDispositivos() throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
			dispositivos = criteria.list();
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

		return dispositivos;
	}

	/**
	 * Método obtenerDispositivo(String idDispositivo) es el encargado de
	 * obtener un dispositivo desde la base de datos búscando por medio del
	 * parametro
	 * 
	 * @param idDispositivo
	 *            con el cual se hace la busqueda.
	 * @return Dispositivo buscado.
	 * @throws MyException
	 */
	@Override
	public Dispositivo obtenerDispositivo(String idDispositivo) throws MyException {
		Dispositivo dispositivo = new Dispositivo();
		Session session = null;
		try {
			session = getSession();
			session.createCriteria(Usuario.class).add(Restrictions.eq("idDispositivo", idDispositivo));
			dispositivo = (Dispositivo) session.get(Dispositivo.class, idDispositivo);
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
		return dispositivo;
	}

	/**
	 * Método crearDispositivo(Dispositivo dispositivo) es el encargado de
	 * agregar un nuevo dispositivo a la base de datos.
	 * 
	 * @param dispositivo
	 *            a crear.
	 * @throws MyException.
	 */
	@Override
	public void crearDispositivo(Dispositivo dispositivo) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(dispositivo);
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
	 * Metodo eliminarDispositivo(Dispositivo dispositivo) es el encargado de
	 * eliminar un dispositivo en la base de datos.
	 * 
	 * @param dispositivo
	 *            a eliminar.
	 * @throws MyException.
	 */
	@Override
	public void eliminarDispositivo(Dispositivo dispositivo) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(dispositivo);
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
	 * Metodo modificarDispositivo(Dispositivo dispositivo) es el encargado de
	 * modificar un dipositivo previamente ingresado en la base de datos
	 * @param dispositivo a modificar.
	 * @throws MyException.
	 */
	@Override
	public void modificarDispositivo(Dispositivo dispositivo) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(dispositivo);
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

}
