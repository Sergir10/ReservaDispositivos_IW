package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.RolDAO;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase encargada de implementar los metodos que se definieron en la interface
 * RolDAO.
 * 
 * @author sergir10
 *
 */
public class RolDAOImpl extends HibernateDaoSupport implements RolDAO {

	/**
	 * Metodo listarRoles() es el encargado de traernos todos los roles
	 * almacenados en la BD
	 * 
	 * @param no
	 *            tiene
	 * @return lista con todos los roles.
	 * @throws MyException
	 */
	@Override
	public List<Rol> listarRoles() throws MyException {
		List<Rol> roles = new ArrayList<Rol>();
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Rol.class);
			roles = criteria.list();
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

		return roles;
	}

	/**
	 * Metodo obteneRol(int idRol) es el encargado de buscar un rol especifico
	 * en la BD.
	 * 
	 * @param idRol por el cual se realizará la búsqueda.
	 * @return Rol obtenido de la busqueda.
	 * @throws MyException
	 */
	@Override
	public Rol obtenerRol(int idRol) throws MyException {
		Rol rol = new Rol();
		Session session = null;
		try {
			session = getSession();
			session.createCriteria(Usuario.class).add(Restrictions.eq("idRol", idRol));
			rol = (Rol) session.get(Rol.class, idRol);
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
		return rol;
	}

}
