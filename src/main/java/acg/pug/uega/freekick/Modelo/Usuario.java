package acg.pug.uega.freekick.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario 
{
	@Id
	private int ID;
	private String Nombre;
	private String Apellido;
	private String Correo;
	private String Contraseña;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	public String probar() {
		
		
		return null;
	}
	
	
	
	

}
