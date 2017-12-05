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

	@PostConstruct
	public void  init() {
		establecimiento = new Establecimiento();
		establecimiento.addCancha(new Cancha());
		//persona.addTelefono(new Telefono());
		//manda a cargar el listado de personas como para tener una instancia de ellas
		loadEstablecimiento();
		loadCancha();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("valor"+loadDatosEditar(id));
		this.loadDatosEditar(id);
	}
	

	@Inject
	private EstablecimientoDAO edao;
	
	private List<Establecimiento> establecimentos;
	private List<Cancha> canchas;
	
	
	
	public List<Cancha> getCanchas() {
		return canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}

	public List<Establecimiento> getEstablecimentos() {
		
		return establecimentos;
		
	}

	public void setEstablecimentos(List<Establecimiento> establecimentos) {
		this.establecimentos = establecimentos;
	}
	
	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

	
	private void loadEstablecimiento() {
		this.establecimentos = edao.ListadoEstablecimiento();
			
		
	}
	private void loadCancha() {
		this.canchas = edao.ListadoCanchas();
			
		
	}
	
	
	public String guardar() {
		//System.out.println(persona);
		try {
			edao.guardar(establecimiento);
			this.loadEstablecimiento();
			this.loadCancha();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		return "ListadoEstablecimiento";
	}
	
	public String loadDatosEditar(int codigo) {
		this.establecimiento = edao.leer(codigo);
		
		return "InsertarEstablecimiento";
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
	 
	 public String borrar(int codigo) {
			edao.borrar(codigo);
			this.loadEstablecimiento();
			this.loadCancha();
			return "ListadoEstablecimiento";
		}
	 public String borrarCancha(int codigo) {
			edao.borrar(codigo);
			this.loadEstablecimiento();
			this.loadCancha();
			return "ListadoEstablecimiento";
		}

		public String addCanchasI() {
			this.establecimiento.addCancha(new Cancha());
			return null;
		}
}