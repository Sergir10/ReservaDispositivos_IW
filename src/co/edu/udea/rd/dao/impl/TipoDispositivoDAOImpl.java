package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.TipoDispositivoDAO;
import co.edu.udea.rd.dto.TipoDispositivo;
import co.edu.udea.rd.exception.MyException;

public class TipoDispositivoDAOImpl extends HibernateDaoSupport implements TipoDispositivoDAO {

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
}
