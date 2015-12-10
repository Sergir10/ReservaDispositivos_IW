package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.PrestamoDAO;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.Prestamo;
import co.edu.udea.rd.dto.PrestamoId;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

public class PrestamoDAOImpl extends HibernateDaoSupport implements PrestamoDAO {

	@Override
	public List<Prestamo> listarPrestamos() throws MyException {
		List<Prestamo> prestamo = new ArrayList<Prestamo>();
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Prestamo.class);
			prestamo = criteria.list();
		} catch (Exception e) {
			throw new MyException(e);
		}

		return prestamo;
	}

	@Override
	public Prestamo obtenerPrestamo(PrestamoId prestamoId) throws MyException {
		Prestamo prestamo = new Prestamo();
		Session session = null;
		try {
			session = getSession();
			session.createCriteria(Usuario.class).add(Restrictions.eq("dispositivo", prestamoId.getDispositivo()));
			session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", prestamoId.getUsuario()));
			prestamo = (Prestamo) session.get(Prestamo.class, prestamoId);
		} catch (Exception e) {
			throw new MyException(e);
		}
		return prestamo;
	}

	@Override
	public void crearPrestamo(Prestamo prestamo) throws MyException {
				
	}

	@Override
	public void modificarPrestamo(Prestamo prestamo) throws MyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPrestasmo(Prestamo prestamo) throws MyException {
		// TODO Auto-generated method stub
		
	}

}