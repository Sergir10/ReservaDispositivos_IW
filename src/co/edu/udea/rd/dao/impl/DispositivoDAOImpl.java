package co.edu.udea.rd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.rd.dao.DispositivoDAO;
import co.edu.udea.rd.dto.Dispositivo;
import co.edu.udea.rd.dto.Usuario;
import co.edu.udea.rd.exception.MyException;

public class DispositivoDAOImpl extends HibernateDaoSupport implements DispositivoDAO {

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
		}

		return dispositivos;
	}

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
		}
		return dispositivo;
	}

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
		} 
	}

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
		} 
	}

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
		} 

	}

}
