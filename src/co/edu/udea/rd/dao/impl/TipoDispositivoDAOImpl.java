package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.TipoDispositivoDAO;
import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

/**
 * Clase encargada de implementar los metodos que se definieron en la interface
 * TipoDispositivoDAO.
 * 
 * @author sergir10
 *
 */
public class TipoDispositivoDAOImpl extends HibernateDaoSupport implements TipoDispositivoDAO {

	/**
	 * Metodo listarTipoDeDispositivos() es el encargado de obtener todos los
	 * tipos de dispositivos almacenados en la base de datos.
	 * 
	 * @return list con todo los tipos de dispositivos en la BD.
	 * @throws MyException
	 */
	@Override
	public List<TipoDispositivo> listarTiposDeDispositivos() throws MyException {
		List<TipoDispositivo> tiposDeDispositivos = new ArrayList<TipoDispositivo>();
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TipoDispositivo.class);
			tiposDeDispositivos = criteria.list();
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

		return tiposDeDispositivos;
	}

	/**
	 * Metodo obtenerTipoDeDispositivo(int idTipoDispositivo) es el encargado de
	 * obtener un tipo de dispositivo especifico que se desee buscar.
	 * 
	 * @param idTipoDispositivo por el cual se realizará la búsqueda.
	 * @return TipoDispositivo buscado.
	 * @throws MyException
	 */
	@Override
	public TipoDispositivo obtenerTipoDeDispositivo(int idTipoDispositivo) throws MyException {
		TipoDispositivo tipoDispositivo = new TipoDispositivo();
		Session session = null;
		try {
			session = getSession();
			session.createCriteria(Usuario.class).add(Restrictions.eq("idTipoDispositivo", idTipoDispositivo));
			tipoDispositivo = (TipoDispositivo) session.get(TipoDispositivo.class, idTipoDispositivo);
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
		return tipoDispositivo;
	}

}
