package acg.pug.uega.freekick.Controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import acg.pug.uega.freekick.Modelo.Establecimiento;
import acg.pug.uega.freekick.Datos.EstablecimientoDAO;
import acg.pug.uega.freekick.Modelo.Cancha;


@ManagedBean
@ViewScoped
public class EstablecimientoController {

	@Inject
    private FacesContext facesContext;
	
	private  Establecimiento establecimiento;
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@PostConstruct
	public void  init() {
		this.establecimiento = new Establecimiento();
		//agregamos un telefono vacio
		//persona.addTelefono(new Telefono());
		//manda a cargar el listado de personas como para tener una instancia de ellas
		//loadPersonas();
	}
	@Inject
	private EstablecimientoDAO edao;
	
	private List<Establecimiento> establecimentos;
	
	public List<Establecimiento> getEstablecimentos() {
		return establecimentos;
	}

	public void setEstablecimentos(List<Establecimiento> establecimentos) {
		this.establecimentos = establecimentos;
	}

	public List<Cancha> getCanchas() {
		return canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}
	
	
	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}
	private List<Cancha> canchas;
	
	private void loadEstablecimiento() {
		this.establecimentos = edao.ListadoEstablecimiento();
	}
	
	public String guardar() {
		//System.out.println(persona);
		try {
			edao.guardar(establecimiento);
			this.loadEstablecimiento();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		return "ListadoPersonas";
	}
	
	public String loadDatosEditar(int codigo) {
		this.establecimiento = edao.leer(codigo);
		return "principal";
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
	 
	 public String borrarPersona(int codigo) {
			edao.borrar(codigo);
			this.loadEstablecimiento();
			return "ListadoPropietario";
		}
		
		
		public String addCanchasI() {
			this.establecimiento.addCancha(new Cancha());
			return null;
		}
	 
}
