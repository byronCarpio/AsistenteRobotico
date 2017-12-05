package acg.pug.uega.freekick.Controlador;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import acg.pug.uega.freekick.Datos.UsuarioDAO;
import acg.pug.uega.freekick.Modelo.Usuario;

@ManagedBean
public class UsuarioController {
	@Inject
    private FacesContext facesContext;
	
	private Usuario usuario;
	
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}

	@Inject
	private UsuarioDAO pdao;
	
	@PostConstruct
	public void  init() {
		usuario = new Usuario();
		loadUsuarios();
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//para obtener el listado de personas desde la base de datos
	//el pdao es el unico que se conecta con la base
	private void loadUsuarios() {
		usuarios = pdao.listadoUsuarios();
	}
	
	public String guardar() {
		System.out.println(usuario);
		try {
			pdao.guardar(usuario);
			loadUsuarios();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		return "ListadoUsuarios";
	}
	
	public String loadDatosEditar(int codigo) {
		usuario = pdao.leer(codigo);
		return "Registra_Usuario";
	}
	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	private String getRootErrorMessage(Exception e) {
	        // Default to general error message that registration failed.
	        String errorMessage = "Registration failed. See server log for more information";
	        if (e == null) {
	            // This shouldn't happen, but return the default messages
	            return errorMessage;
	        }

	        // Start with the exception and recurse to find the root cause
	        Throwable t = e;
	        while (t != null) {
	            // Get the message from the Throwable class instance
	            errorMessage = t.getLocalizedMessage();
	            t = t.getCause();
	        }
	        // This is the root cause message
	        return errorMessage;
	    }
	 
	public String borrarUsuario(int codigo) {
		pdao.borrar(codigo);
		loadUsuarios();
		return "ListadoUsuarios";
	}
	
}
