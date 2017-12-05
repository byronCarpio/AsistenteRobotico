package acg.pug.uega.freekick.Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import acg.pug.uega.freekick.Modelo.Cancha;
import acg.pug.uega.freekick.Modelo.Establecimiento;
import acg.pug.uega.freekick.Modelo.Servicios;


@Stateless
public class EstablecimientoDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Establecimiento establecimiento) {
		em.persist(establecimiento);
	}
	
	public void actualizar(Establecimiento establecimiento) {
		em.merge(establecimiento);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
		
	}
	public Establecimiento leer(int codigo) {
		return em.find(Establecimiento.class, codigo);
	}
	
	public List<Establecimiento> listadoEstablecimiento() {
		String jpql = "SELECT e FROM Establecimiento e";
		//System.out.println("que me devuelve"+jpql);
		Query query  = em.createQuery(jpql, Establecimiento.class);
		List <Establecimiento> listado = query.getResultList();
		// se va a leer desde el personaController
		return listado;
	}
	
	public List<Cancha> listadoCanchas() {
		String jpql = "SELECT c FROM Cancha c";
		//System.out.println("que me devuelve"+jpql);
		Query query  = em.createQuery(jpql, Cancha.class);
		List <Cancha> listado = query.getResultList();
		// se va a leer desde el personaController
		return listado;
	}
	public List<Servicios> listadoServicios() {
		String jpql = "SELECT s FROM Servicios s";
		//System.out.println("que me devuelve"+jpql);
		Query query  = em.createQuery(jpql, Servicios.class);
		List <Servicios> listado = query.getResultList();
		// se va a leer desde el personaController
		return listado;
	}
	
	public void guardar(Establecimiento establecimiento) {
		Establecimiento p = leer(establecimiento.getCodigo());
		if( p == null)
			insertar(establecimiento);
		else
			actualizar(establecimiento);
	}
	
}

	