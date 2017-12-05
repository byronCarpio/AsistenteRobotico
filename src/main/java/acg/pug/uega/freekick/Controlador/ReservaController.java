package acg.pug.uega.freekick.Controlador;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import acg.pug.uega.freekick.Datos.ReservaDAO;
import acg.pug.uega.freekick.Modelo.Cancha;
import acg.pug.uega.freekick.Modelo.Reserva;

@ManagedBean
public class ReservaController {
	@Inject
    private FacesContext facesContext;
	
	private Reserva reserva;
	
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		loadDatosEditar(id);
	}

	@Inject
	private ReservaDAO pdao;
	
	@PostConstruct
	public void  init() {
		reserva = new Reserva();
		loadReservas();
	}
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	//para obtener el listado de personas desde la base de datos
	//el pdao es el unico que se conecta con la base
	private void loadReservas() {
		reservas = pdao.listadoReservas();
	}
	
	public String guardar() {
		System.out.println(reserva);
		try {
			pdao.guardar(reserva);
			loadReservas();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
			return null;
		}
		return "ListadoReservas";
	}
	
	public String loadDatosEditar(int codigo) {
		reserva = pdao.leer(codigo);
		return "Registra_Reserva";
	}
	
	private List<Cancha> canchas;
	
	public List<Cancha> getCanchas() {
		return canchas;
	}
	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}
	
	private void loadCanchas() {
		canchas = pdao.ListadoCanchas();
	}
	
	private List<Reserva> reservas;

	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
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
	 
	public String borrarReserva(int codigo) {
		pdao.borrar(codigo);
		loadReservas();
		return "ListadoReservas";
	}
	
}
