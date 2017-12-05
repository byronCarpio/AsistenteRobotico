package acg.pug.uega.freekick.Modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tbl_usuario")
public class Usuario {
	
    @NotNull(message="El codigo es obligatorio")
	@Id
	@Column(name = "usr_codigo")
	private int codigo;

    @NotNull(message="El nombre es obligatorio")
    @NotBlank(message="El nombre es obligatorio")
	@Size(min = 4, max = 20)
	@Column(name = "usr_nombre")
	private String nombre;

    @NotNull(message="El apellido es obligatorio")
    @NotBlank(message="El apellido es obligatorio")
	@Size(min = 4, max = 20)
	@Column(name = "usr_apellido")
	private String apellido;
	
	@Column(name = "usr_latitud")
	private double latitud;
	
	@Column(name = "usr_longitud")
	private double longitud;

    @NotNull(message="El campo sexo es obligatorio")
    @NotBlank(message="El campo sexo es obligatorio")
    @Pattern(regexp = "^[M|F]{1}$", message ="Ingrese su sexo usando las letras M o F")
	@Column(name = "usr_sexo")
	private String sexo;

    @NotNull(message="La fecha de nacimiento es obligatoria")
	@Past(message = "La fecha de nacimiento debe ser del pasado")
	@Temporal(TemporalType.DATE)
	@Column(name = "usr_fecha_nac")
	private Date fecha_nac;

    @NotNull(message="El correo es obligatorio")
    @NotBlank(message="El correo es obligatorio")
	@Email
	@Column(name = "usr_correo")
	private String correo;
	
    @NotNull(message="La contraseña es obligatoria")
    @NotBlank(message="La contraseña es obligatoria")
	@Size(min = 4, max = 20)
	@Column(name = "usr_contraseña")
	private String contraseña;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
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

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo +", f_Nacimiento=" + fecha_nac + ", correo=" + correo + ", contraseña=" + contraseña + "]";
	}	
}