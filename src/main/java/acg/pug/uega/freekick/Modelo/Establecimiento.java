package acg.pug.uega.freekick.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="tbl_establecimiento")
public class Establecimiento {

	@Id
	@Column(name="est_codigo", length = 6)
	private int codigo;
	
	@NotNull
	@Size(min=4,max=20)
	@Column(name="est_nombres")
	private String nombres;
	
	
	@NotNull
	@Size(min=4,max=30)
	@Column(name="est_nombreLocal")
	private String nombre_Local;
	

	@NotNull
	@Size(max=10)
	@Column(name="est_telefono")
	private String telefono;
	
	@Email
	@Column(name="est_direccion")
	private String direccion;
	
	
	@Email
	@Column(name="est_email")
	private String correo;
	
	@NotNull
	@Size(min=6,max=12)
	@Column(name="est_contraseña")
	private String contraseña;
	
	
	@NotNull
	@Size(max=30)
	@Column(name="est_lactitud")
	private double latitud;
	
	
	@NotNull
	@Size(max=30)
	@Column(name="est_lactitud")
	private double longitud;

	
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="est_can_codigo", referencedColumnName="est_codigo")
	private List<Cancha> canchas;
	
	
	

	public List<Cancha> getCanchas() {
		return canchas;
	}


	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getNombre_Local() {
		return nombre_Local;
	}


	public void setNombre_Local(String nombre_Local) {
		this.nombre_Local = nombre_Local;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}


	@Override
	public String toString() {
		return "Establecimiento [codigo=" + codigo + ", nombres=" + nombres + ", nombre_Local=" + nombre_Local
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", contraseña="
				+ contraseña + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	public void addCancha(Cancha cancha) {
		if (canchas ==null) 
			canchas = new ArrayList<>();
		canchas.add(cancha);
		
	}
	
	
	

	
	
}
