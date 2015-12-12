package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.RolDAO;
import co.edu.udea.rd.dto.Rol;
import co.edu.udea.rd.exception.MyException;

public class RolDAOImpl extends HibernateDaoSupport implements RolDAO{

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

}
