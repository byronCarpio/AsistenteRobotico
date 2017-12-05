package acg.pug.uega.freekick.Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import acg.pug.uega.freekick.Modelo.Usuario;

@Stateless
public class UsuarioDAO {
	
	//contexto de inyecciones y accion de java que hace que 
	//facilita el trabajo con los objetos gestionado desde 
	//el servidor(managed bean,ejb)
	@Inject
	private EntityManager em;
	
	public void insertar(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void actualizar(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	
	public Usuario leer(int codigo) {
		return em.find(Usuario.class, codigo);
	}
	
	//devuelve una coleccion de usuarios
	public List<Usuario> listadoUsuarios() {
		String jpql = "SELECT p FROM Usuario p";
		Query query  = em.createQuery(jpql, Usuario.class);
		List <Usuario> listadoUsuarios = query.getResultList();
		// se va a leer desde el usuarioController
		return listadoUsuarios;
	}
	
	public void guardar(Usuario usuario) {
		Usuario p = leer(usuario.getCodigo());
		if( p == null)
			insertar(usuario);
		else
			actualizar(usuario);
	}

}
