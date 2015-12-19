package co.edu.udea.rd.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
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
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}

		return prestamo;
	}

	@Override
	public void crearPrestamo(Prestamo prestamo) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(prestamo);
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
	public void modificarPrestamo(Prestamo prestamo) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(prestamo);
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
	public void eliminarPrestamo(Prestamo prestamo) throws MyException {
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(prestamo);
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
	public Boolean validarDisponibilidadPrestamo(Prestamo prestamo) throws MyException {

		List<Dispositivo> dispo1 = new ArrayList<Dispositivo>();
		List<Dispositivo> dispo2 = new ArrayList<Dispositivo>();
		List<Dispositivo> dispositivosDisponibles = null;

		Dispositivo dispositivoPrestar = new Dispositivo();
		Session session = null;

		// Se hace la conversion del tipo Date a String
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaInicioString = fechaHora.format(prestamo.getFechaInicialPrestamo());
		String fechaFinString = fechaHora.format(prestamo.getFechaFinalPrestamo());
		try {
			session = getSession();
			// Se realiza una consulta en lenguaje SQL en la que se seleccionan
			// la referencia del dispositivo disponible
			Query query1 = (Query) session.createSQLQuery("SELECT disp.idDispositivo FROM `prestamo` as pres, "
					+ "`dispositivo` as disp WHERE pres.fechaInicialPrestamo not between '" + fechaInicioString + "' "
					+ "and '" + fechaFinString
					+ "' and pres.estado != 'prestado' and disp.idDispositivo = pres.dispositivo");

			Query query2 = (Query) session.createSQLQuery("SELECT disp.idDispositivo FROM `dispositivo` as disp WHERE "
					+ "NOT EXISTS (select * from `prestamo` as prest where disp.idDispositivo = prest.dispositivo)");

			// Se almacena en una variable de tipo String el resultado unico de
			// la consulta
			dispo1 = (List<Dispositivo>) query1.list();
			dispo2 = (List<Dispositivo>) query2.list();

			// Se verifica si la consulta devolvio un String diferente de nulo
			if (dispo1 == null) {
				if (dispo2 == null) {
					return false;
				}
				dispositivosDisponibles = new ArrayList<Dispositivo>();
				dispositivosDisponibles = dispo2;
			} else if (dispo2 == null) {
				dispositivosDisponibles = new ArrayList<Dispositivo>();
				dispositivosDisponibles = dispo1;
			} else {
				dispositivosDisponibles = new ArrayList<Dispositivo>();
				dispositivosDisponibles = dispo1;
				dispositivosDisponibles.addAll((List<Dispositivo>) dispo2);
			}

			// Consultamos que el dipositivo solicitado pertenezca a esta lista,
			// es decir, que esté disponible

			for (int i = 0; i < dispositivosDisponibles.size(); i++) {
				Dispositivo d = (Dispositivo) prestamo.getPrestamoId().getDispositivo();
			}

		} catch (Exception e) {
			throw new MyException(e);
		}
		return false;
	}
}