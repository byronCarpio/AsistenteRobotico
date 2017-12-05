package acg.pug.uega.freekick.Datos;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import acg.pug.uega.freekick.Modelo.Cancha;
import acg.pug.uega.freekick.Modelo.Reserva;
//existen los ejb de sesion es es StayFull
//				 	Sigleton que seria un Scope de un ManagedBean
@Stateless
public class ReservaDAO {
	
	//contexto de inyecciones y accion de java que hace que 
	//facilita el trabajo con los objetos gestionado desde 
	//el servidor(managed bean,ejb)
	@Inject
	private EntityManager em;
	
	public void insertar(Reserva reserva) {
		em.persist(reserva);
	}
	
	public void actualizar(Reserva reserva) {
		em.merge(reserva);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	
	public Reserva leer(int codigo) {
		return em.find(Reserva.class, codigo);
	}
	
	//devuelve una coleccion de reservas
	public List<Reserva> listadoReservas() {
		String jpql = "SELECT p FROM Reserva p";
		Query query  = em.createQuery(jpql, Reserva.class);
		List <Reserva> listadoReservas = query.getResultList();
		// se va a leer desde el reservaController
		return listadoReservas;
	}
	
	public List<Cancha> ListadoCanchas() {
		String jpql = "SELECT c FROM Cancha c";
		System.out.println("que me devuelve"+jpql);
		Query query  = em.createQuery(jpql, Cancha.class);
		List <Cancha> ListadoCanchas = query.getResultList();
		// se va a leer desde el personaController
		return ListadoCanchas;
	}
	
	public void guardar(Reserva reserva) {
		Reserva p = leer(reserva.getCodigo());
		if( p == null)
			insertar(reserva);
		else
			actualizar(reserva);
	}

}
