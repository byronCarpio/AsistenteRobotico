package acg.pug.uega.freekick.Modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_cancha")
public class Cancha {
	
	@Id
	@Column(name="can_codigo", length = 6)
	private int codigo;
	
	@NotNull
	@Size(min=4,max=20)
	@Column(name="can_nombres")
	private String nombre;
	
	@NotNull
	@Size(min=4,max=50)
	@Column(name="can_direccion")
	private String direccion;
	
	@NotNull
	
	@Column(name="can_precio")
	private double precio;
	
	@NotNull
	@Size(min=4,max=50)
	@Column(name="can_tipo")
	private String tipo;
	
	@NotNull
	@Size(min=2,max=3)
	@Column(name="can_Cantidad")
	private String maxJugadores;
	
	@NotNull
	@Size(min=4,max=50)
	@Column(name="can_informacion")
	private String informacion_Adicional;
	
	@NotNull
	@Size(min=6,max=50)
	@Column(name="can_horario")
	private String horario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaxJugadores() {
		return maxJugadores;
	}

	public void setMaxJugadores(String maxJugadores) {
		this.maxJugadores = maxJugadores;
	}

	public String getInformacion_Adicional() {
		return informacion_Adicional;
	}

	public void setInformacion_Adicional(String informacion_Adicional) {
		this.informacion_Adicional = informacion_Adicional;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Cancha [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", precio=" + precio
				+ ", tipo=" + tipo + ", maxJugadores=" + maxJugadores + ", informacion_Adicional="
				+ informacion_Adicional + ", horario=" + horario + "]";
	}

}

